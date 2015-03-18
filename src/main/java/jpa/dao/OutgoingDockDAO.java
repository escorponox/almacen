package jpa.dao;

import jpa.OutgoingDock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("outgoingDockDAO")
@Transactional
public class OutgoingDockDAO {

    @PersistenceContext
    private EntityManager em;

    public void addOutgoingDock(OutgoingDock outgoingDock) {
        em.persist(outgoingDock);
    }

    public void updateOutgoingDock(OutgoingDock outgoingDock) {
        em.merge(outgoingDock);
    }

    public Collection<OutgoingDock> listAll() {
        Query query = em.createQuery("select a from OutgoingDock a");
        return query.getResultList();
    }

    public OutgoingDock getOutgoingDockById(Long id) {
        return em.find(OutgoingDock.class, id);
    }

}
