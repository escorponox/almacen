package jpa.dao;

import jpa.Item;
import jpa.Location;
import jpa.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("stockDAO")
@Transactional
public class StockDAO {

    @PersistenceContext
    private EntityManager em;

    public void addStock(Stock stock) {
        em.persist(stock);
    }

    public void updateStock(Stock item) {
        em.merge(item);
    }

    public List<Stock> listAll() {
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
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }

    public List<Stock> getAvailableStockBydItem(Item item) {
        Query query = em.createQuery("select a from Stock a where a.location is not null and a.item = :item");
        query.setParameter("item", item);
        return query.getResultList();
    }


}
