package jpa.dao;

import jpa.IncomingDock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("incomingDockDAO")
@Transactional
public class IncomingDockDAO {

    @PersistenceContext
    private EntityManager em;

    public void addIncomingDock(IncomingDock incomingDock) {
        em.persist(incomingDock);
    }

    public void updateIncomingDock(IncomingDock incomingDock) {
        em.merge(incomingDock);
    }

    public List<IncomingDock> listAll() {
        Query query = em.createQuery("select a from IncomingDock a");
        return query.getResultList();
    }

    public IncomingDock getIncomingDockById(Long id) {
        return em.find(IncomingDock.class, id);
    }

}
