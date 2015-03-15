package jpa.dao;

import jpa.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("providerDao")
@Transactional
public class ProviderDAO {

    @PersistenceContext
    private EntityManager em;

    public void addprovider(Provider provider) {
        em.persist(provider);
    }

    public void updateprovider(Provider provider) {
        em.merge(provider);
    }

    public Collection<Provider> listAll() {
        Query query = em.createQuery("select a from Provider a");
        return query.getResultList();
    }

    public Provider getproviderById(Long id) {
        return em.find(Provider.class, id);
    }

    public Provider getProviderByNif(String nif) {
        Query query = em.createQuery("select a from Provider a where a.nif = :nif");
        query.setParameter("nif", nif);
        List<Provider> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
