package jpa.dao;

import jpa.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("itemDao")
@Transactional
public class ItemDAO {

    @PersistenceContext
    private EntityManager em;

    public void addItem(Item item) {
        em.persist(item);
    }

    public void updateItem(Item item) {
        em.merge(item);
    }

    public List<Item> listAll() {
        Query query = em.createQuery("select a from Item a");
        return query.getResultList();
    }

    public Item getItemById(Long id) {
        return em.find(Item.class, id);
    }

    public Item getItemByCode(String code) {
        Query query = em.createQuery("select a from Item a where a.code = :code");
        query.setParameter("code", code);
        List<Item> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public List<Item> searchByCode(String code) {
        Query query = em.createQuery("select a from Item a where a.code like :code");
        query.setParameter("code", "%" + code + "%");
        return query.getResultList();
    }
}
