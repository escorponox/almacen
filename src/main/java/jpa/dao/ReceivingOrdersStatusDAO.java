package jpa.dao;

import jpa.ReceivingOrder;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("receivingOrdersStatusDao")
@Transactional
public class ReceivingOrdersStatusDAO {

    @PersistenceContext
    private EntityManager em;

    public Collection<ReceivingOrder> listAll() {
        Query query = em.createQuery("select a from ReceivingOrder a");
        return query.getResultList();
    }

    public ReceivingOrder getReceivingOrdersStatusById(Long id) {
        return em.find(ReceivingOrder.class, id);
    }

    public ReceivingOrder getReceivingOrdersStatusByStatus(ReceivingOrdersStatusEnum receivingOrdersStatusEnum) {
        Query query = em.createQuery("select a from ReceivingOrder a where a.status = :status");
        query.setParameter("status", receivingOrdersStatusEnum);
        return (ReceivingOrder) query.getSingleResult();
    }
}
