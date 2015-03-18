package jpa.dao;

import jpa.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAO {

    @PersistenceContext
    private EntityManager em;

    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    public void deleteEntity(Customer customer) {
        em.remove(em.find(Customer.class, customer.getId()));
    }

    public void updateEntity(Customer customer) {
        em.merge(customer);
    }

    public Collection<Customer> listAll() {
        Query query = em.createQuery("select a from Customer a");
        return query.getResultList();
    }

    public Customer getCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    public Customer getCustomerByNif(String nif) {
        Query query = em.createQuery("select a from Customer a where a.nif = :nif");
        query.setParameter("nif", nif);
        List<Customer> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}