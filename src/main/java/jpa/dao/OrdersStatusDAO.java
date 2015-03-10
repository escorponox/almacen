package jpa.dao;

import jpa.OrdersStatus;
import jpa.enums.OrdersStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("ordersStatusDao")
@Transactional
public class OrdersStatusDAO {

    @PersistenceContext
    private EntityManager em;

    public Collection<OrdersStatus> listAll() {
        Query query = em.createQuery("select a from OrdersStatus a");
        return query.getResultList();
    }

    public OrdersStatus getOrdersStatusById(Long id) {
        return em.find(OrdersStatus.class, id);
    }

    public OrdersStatus getOrdersStatusByStatus(OrdersStatusEnum ordersStatusEnum) {
        Query query = em.createQuery("select a from OrdersStatus a where a.status = :status");
        query.setParameter("status", ordersStatusEnum);
        return (OrdersStatus) query.getSingleResult();
    }
}
