package jpa.dao;


import jpa.Locations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("locationsDao")
@Transactional
public class LocationsDAO {

    @PersistenceContext
    private EntityManager em;

    public void addLocation(Locations locations) {
        em.persist(locations);
    }
}
