package jpa.dao;

import jpa.LocateAction;
import jpa.User;
import jpa.enums.ActionStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("locateActionDAO")
@Transactional
public class LocateActionDAO {

    @PersistenceContext
    private EntityManager em;

    public void addLocateAction(LocateAction locateAction) {
        em.persist(locateAction);
    }

    public void updateLocateAction(LocateAction locateAction) {
        em.merge(locateAction);
    }

    public Collection<LocateAction> listAll() {
        Query query = em.createQuery("select a from LocateAction a");
        return query.getResultList();
    }

    public LocateAction getLocateActionById(Long id) {
        return em.find(LocateAction.class, id);
    }

    public LocateAction getAssignedAction(User user) {
        Query query = em.createQuery("select a from LocateAction a where a.picker = :user and a.status.status = :status");
        query.setParameter("user", user);
        query.setParameter("status", ActionStatusEnum.AS);
        List<LocateAction> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public LocateAction getFirstUnassignedLocateAction() {
        Query query = em.createQuery("select a from LocateAction a where  a.status.status = :status order by a.receiptAction.receivedAt,a.receiptAction.receivingOrderLine.item.code");
        query.setParameter("status", ActionStatusEnum.CR);
        List<LocateAction> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
