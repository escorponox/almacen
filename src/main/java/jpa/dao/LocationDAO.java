package jpa.dao;


import jpa.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository("locationDao")
@Transactional
public class LocationDAO {

    @PersistenceContext
    private EntityManager em;

    public void addLocation(Location location) {
        em.persist(location);
    }

    public void deleteLocation(Location location) {
        em.remove(em.find(Location.class, location.getId()));
    }

    public void updateLocation(Location location) {
        em.merge(location);
    }

    public Collection<Location> listAll() {
        Query query = em.createQuery("select a from Location a");
        return query.getResultList();
    }

    public Location getLocationById(Long id) {
        return em.find(Location.class, id);
    }
}
