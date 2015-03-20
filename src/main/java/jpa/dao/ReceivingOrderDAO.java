package jpa.dao;

import jpa.ReceivingOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("receivingOrderDao")
@Transactional
public class ReceivingOrderDAO {

    @PersistenceContext
    private EntityManager em;

    public void addReceivingOrder(ReceivingOrder receivingOrder) {
        em.persist(receivingOrder);
    }

    public void updateReceivingOrder(ReceivingOrder receivingOrder) {
        em.merge(receivingOrder);
    }

    public List<ReceivingOrder> listAll() {
        Query query = em.createQuery("select a from ReceivingOrder a");
        return query.getResultList();
    }

    public ReceivingOrder getReceivingOrderById(Long id) {
        return em.find(ReceivingOrder.class, id);
    }

    public ReceivingOrder getReceivingOrderByCode(Long code) {
        Query query = em.createQuery("select a from ReceivingOrder a where a.code = :code");
        query.setParameter("code", code);
        List<ReceivingOrder> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
