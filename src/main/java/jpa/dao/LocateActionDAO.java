package jpa.dao;

import jpa.IncomingDock;
import jpa.LocateAction;
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

    public void updateReceiptAction(LocateAction locateAction) {
        em.merge(locateAction);
    }

    public Collection<LocateAction> listAll() {
        Query query = em.createQuery("select a from LocateAction a");
        return query.getResultList();
    }

    public LocateAction getLocateActionById(Long id) {
        return em.find(LocateAction.class, id);
    }

    public List<LocateAction> getUnassignedLocateActionByDock(IncomingDock incomingDock) {
        Query query = em.createQuery("select a from LocateAction a where a.receiptAction.incomingDock = :incomingDock and a.status.status = :status");
        query.setParameter("incomingDock", incomingDock);
        query.setParameter("status", ActionStatusEnum.CR);
        return query.getResultList();
    }
}
