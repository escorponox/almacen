package jpa.dao;


import jpa.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("usersDao")
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

    public void deleteUser(User user) {
        em.remove(em.find(User.class, user.getId()));
    }

    public void updateUser(User user) {
        em.merge(user);
    }

    public Collection<User> listAll() {
        Query query = em.createQuery("select a from User a");
        return query.getResultList();
    }

    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    public User getUserByUsername(String username) {
        Query query = em.createQuery("select a from User a where a.username = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
