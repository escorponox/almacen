package jpa.dao;


import jpa.RoleType;
import jpa.enums.RoleTypeEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("roleTypeDao")
@Transactional
public class RoleTypeDAO {

    @PersistenceContext
    private EntityManager em;

    public List<RoleType> listAll() {
        Query query = em.createQuery("select a from RoleType a");
        return query.getResultList();
    }

    public RoleType getUserById(Long id) {
        return em.find(RoleType.class, id);
    }

    public RoleType getRoleTypeByRole(RoleTypeEnum roleType) {
        Query query = em.createQuery("select a from RoleType a where a.role = :roleType");
        query.setParameter("roleType", roleType);
        return (RoleType) query.getSingleResult();
    }
}
