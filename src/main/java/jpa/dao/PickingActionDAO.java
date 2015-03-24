package jpa.dao;

import jpa.Container;
import jpa.Order;
import jpa.PickingAction;
import jpa.enums.ActionStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<PickingAction> listAll() {
        Query query = em.createQuery("select a from PickingAction a");
        return query.getResultList();
    }

    public PickingAction getPickingActionById(Long id) {
        return em.find(PickingAction.class, id);
    }

    public List<PickingAction> getCreatedPickingActionsByContainer(Container container) {
        Query query = em.createQuery("select a from PickingAction a where a.container = :container and a.status.status = :status");
        query.setParameter("container", container);
        query.setParameter("status", ActionStatusEnum.CR);
        return query.getResultList();
    }

    public PickingAction getNextActionByContainer(Container container) {
        Query query = em.createQuery("select a from PickingAction a where a.container = :container and a.status.status = :status order by a.seq");
        query.setParameter("container", container);
        query.setParameter("status", ActionStatusEnum.AS);
        List<PickingAction> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
}
