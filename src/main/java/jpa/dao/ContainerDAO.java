package jpa.dao;

import jpa.Container;
import jpa.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("containerDAO")
@Transactional
public class ContainerDAO {

    @PersistenceContext
    private EntityManager em;

    public void addContainer(Container container) {
        em.persist(container);
    }

    public void updateContainer(Container container) {
        em.merge(container);
    }

    public List<Container> listAll() {
        Query query = em.createQuery("select a from Container a");
        return query.getResultList();
    }

    public Container getContainerById(Long id) {
        return em.find(Container.class, id);
    }

    public Container getOrderByOrder(Order order) {
        Query query = em.createQuery("select a from Container a where a.order = :order");
        query.setParameter("order", order);
        List<Container> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
