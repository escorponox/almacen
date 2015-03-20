package jpa.dao;

import jpa.ReceivingOrder;
import jpa.ReceivingOrdersStatus;
import jpa.enums.ReceivingOrdersStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("receivingOrdersStatusDao")
@Transactional
public class ReceivingOrdersStatusDAO {

    @PersistenceContext
    private EntityManager em;

    public List<ReceivingOrder> listAll() {
        Query query = em.createQuery("select a from ReceivingOrder a");
        return query.getResultList();
    }

    public ReceivingOrder getReceivingOrdersStatusById(Long id) {
        return em.find(ReceivingOrder.class, id);
    }

    public ReceivingOrdersStatus getReceivingOrdersStatusByStatus(ReceivingOrdersStatusEnum receivingOrdersStatusEnum) {
        Query query = em.createQuery("select a from ReceivingOrdersStatus a where a.status = :status");
        query.setParameter("status", receivingOrdersStatusEnum);
        return (ReceivingOrdersStatus) query.getSingleResult();
    }
}
