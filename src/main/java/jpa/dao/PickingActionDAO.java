package jpa.dao;

import jpa.Order;
import jpa.PickingAction;
import jpa.enums.ActionStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("pickingActionDAO")
@Transactional
public class PickingActionDAO {

    @PersistenceContext
    private EntityManager em;

    public void addPickingAction(PickingAction pickingAction) {
        em.persist(pickingAction);
    }

    public void updatePickingAction(PickingAction pickingAction) {
        em.merge(pickingAction);
    }

    public Collection<PickingAction> listAll() {
        Query query = em.createQuery("select a from PickingAction a");
        return query.getResultList();
    }

    public PickingAction getPickingActionById(Long id) {
        return em.find(PickingAction.class, id);
    }

    public PickingAction getNextActionByOrder(Order order) {
        Query query = em.createQuery("select a from PickingAction a where a.orderLine.order = :order and a.status.status = :status order by a.seq");
        query.setParameter("order", order);
        query.setParameter("status", ActionStatusEnum.AS);
        List<PickingAction> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
