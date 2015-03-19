package jpa.dao;


import jpa.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository("orderDAO")
@Transactional
public class OrderDAO {

    @PersistenceContext
    private EntityManager em;

    public void addOrder(Order order) {
        em.persist(order);
    }

    public void updateOrder(Order order) {
        em.merge(order);
    }

    public Collection<Order> listAll() {
        Query query = em.createQuery("select a from Order a");
        return query.getResultList();
    }

    public Order getOrderById(Long id) {
        return em.find(Order.class, id);
    }

    public Order getOrderByCode(Long code) {
        Query query = em.createQuery("select a from Order a where a.code = :code");
        query.setParameter("code", code);
        List<Order> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public Long getOrderCodeFromSequence() {
        Query q = em.createNativeQuery("SELECT ORDERS_CODE_SEQ.nextval from DUAL");
        BigDecimal result = (BigDecimal) q.getSingleResult();
        return result.longValue();
    }
}
