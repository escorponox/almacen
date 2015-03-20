package jpa.dao;

import jpa.ActionStatus;
import jpa.enums.ActionStatusEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("actionStatusDao")
@Transactional
public class ActionStatusDAO {

    @PersistenceContext
    private EntityManager em;

    public List<ActionStatus> listAll() {
        Query query = em.createQuery("select a from ActionStatus a");
        return query.getResultList();
    }

    public ActionStatus getActionStatusById(Long id) {
        return em.find(ActionStatus.class, id);
    }

    public ActionStatus getActionStatusByStatus(ActionStatusEnum actionStatusEnum) {
        Query query = em.createQuery("select a from ActionStatus a where a.status = :status");
        query.setParameter("status", actionStatusEnum);
        return (ActionStatus) query.getSingleResult();
    }
}
