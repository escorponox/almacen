package jpa.dao;

import jpa.Order;
import jpa.OrderLine;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("orderLineDAO")
@Transactional
public class OrderLineDAO {

    @PersistenceContext
    private EntityManager em;

    public void addOrderLine(OrderLine orderLine) {
        em.persist(orderLine);
    }

    public void updateOrderLine(OrderLine orderLine) {
        em.merge(orderLine);
    }

    public List<OrderLine> listAll() {
        Query query = em.createQuery("select a from OrderLine a");
        return query.getResultList();
    }

    public OrderLine getOrderLineById(Long id) {
        return em.find(OrderLine.class, id);
    }

    public List<OrderLine> getOrderLinesByOrder(Order order) {
        Query query = em.createQuery("select a from OrderLine a where a.order = :order");
        query.setParameter("order", order);
        return query.getResultList();
    }

    public OrderLine getOrderLineByOrderAndLineNumber(Order order, Integer lineNumber) {
        Query query = em.createQuery("select a from OrderLine a where a.order = :order and a.lineNumber = :lineNumber");
        query.setParameter("order", order);
        query.setParameter("lineNumber", lineNumber);
        List<OrderLine> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public List<OrderLine> getOrderLineForPicking(Order order) {
        Query query = em.createQuery("select a from OrderLine a where a.order = :order order by a.item.location.seq asc");
        query.setParameter("order", order);
        return query.getResultList();
    }
}