package jpa.dao;


import jpa.User;
import jpa.UserRole;
import jpa.enums.RoleTypeEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("userRoleDao")
@Transactional
public class UserRoleDAO {

    @PersistenceContext
    private EntityManager em;

    public void addUserRole(UserRole userRole) {
        em.persist(userRole);
    }

    public void deleteUserRole(UserRole userRole) {
        em.remove(em.find(UserRole.class, userRole.getId()));
    }

    public void updateUserRole(UserRole userRole) {
        em.merge(userRole);
    }

    public Collection<UserRole> listAll() {
        Query query = em.createQuery("select a from UserRole a");
        return query.getResultList();
    }

    public UserRole getUserRoleById(Long id) {
        return em.find(UserRole.class, id);
    }

    public UserRole getUserRoleByUserAndRoleTypeEnum(User user, RoleTypeEnum roleTypeEnum) {
        Query query = em.createQuery("select ur from UserRole ur where ur.user = :user and ur.role.role = :roleTypeEnum");
        query.setParameter("user", user);
        query.setParameter("roleTypeEnum", roleTypeEnum);
        return (UserRole) query.getSingleResult();
    }
}
