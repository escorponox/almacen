package jpa.dao;

import jpa.Item;
import jpa.Location;
import jpa.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("stockDAO")
@Transactional
public class StockDAO {

    @PersistenceContext
    private EntityManager em;

    public void addStock(Stock Stock) {
        em.persist(Stock);
    }

    public void updateStock(Stock item) {
        em.merge(item);
    }

    public Collection<Stock> listAll() {
        Query query = em.createQuery("select a from Stock a");
        return query.getResultList();
    }

    public Stock getStockById(Long id) {
        return em.find(Stock.class, id);
    }

    public Stock getStockByLocationAndItem(Item item, Location location) {
        Query query = em.createQuery("select a from Stock a where a.location = :location and a.item = :item");
        query.setParameter("item", item);
        query.setParameter("location", location);
        List<Stock> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

}
