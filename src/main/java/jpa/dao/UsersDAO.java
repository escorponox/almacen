package jpa.dao;

import jpa.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Carlos Coves Prieto on 2/1/15.
 */
@Repository("usersDAO")
@Transactional
public class UsersDAO {

    @PersistenceContext
    private EntityManager em;

    public void addEntity(Users users) {
        em.persist(users);
    }

    public void deleteEntity(Users users) {
        em.remove(em.find(Users.class, users.getId()));
    }

    public void updateEntity(Users beanEntity) {
        em.merge(beanEntity);
    }

    public Collection<Users> listAll() {
        Query query = em.createQuery("select a from Users a");
        return query.getResultList();
    }

}