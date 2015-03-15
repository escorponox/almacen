package jpa.dao;

import jpa.ReceivingOrder;
import jpa.ReceivingOrderLine;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("receivingOrderLineLineDao")
@Transactional
public class ReceivingOrderLineDAO {

    @PersistenceContext
    private EntityManager em;

    public void addReceivingOrderLine(ReceivingOrderLine receivingOrderLine) {
        em.persist(receivingOrderLine);
    }

    public void updateReceivingOrderLine(ReceivingOrderLine receivingOrderLine) {
        em.merge(receivingOrderLine);
    }

    public void deleteReceivingOrderLine(ReceivingOrderLine receivingOrderLine) {
        em.remove(receivingOrderLine);
    }

    public Collection<ReceivingOrderLine> listAll() {
        Query query = em.createQuery("select a from ReceivingOrderLine a");
        return query.getResultList();
    }

    public ReceivingOrderLine getReceivingOrderLineById(Long id) {
        return em.find(ReceivingOrderLine.class, id);
    }

    public List<ReceivingOrderLine> getReceivingOrderLinesByOrder(ReceivingOrder receivingOrder) {
        Query query = em.createQuery("select a from ReceivingOrderLine a where a.receivingOrder = :receivingOrder");
        query.setParameter("receivingOrder", receivingOrder);
        return query.getResultList();
    }

    public ReceivingOrderLine getReceivingOrderLineByOrderAndLineNumber(ReceivingOrder receivingOrder, Integer lineNumber) {
        Query query = em.createQuery("select a from ReceivingOrderLine a where a.receivingOrder = :receivingOrder and a.lineNumber = :lineNumber");
        query.setParameter("receivingOrder", receivingOrder);
        query.setParameter("lineNumber", lineNumber);
        List<ReceivingOrderLine> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    public void deleteReceivingOrderLines(List<ReceivingOrderLine> receivingOrderLines) {
        for (ReceivingOrderLine receivingOrderLine : receivingOrderLines) {
            em.remove(receivingOrderLine);
        }
    }
}
