package jpa.dao;

import jpa.ReceiptAction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository("receiptActionDAO")
@Transactional
public class ReceiptActionDAO {

    @PersistenceContext
    private EntityManager em;

    public void addReceiptAction(ReceiptAction receiptAction) {
        em.persist(receiptAction);
    }

    public void updateReceiptAction(ReceiptAction receiptAction) {
        em.merge(receiptAction);
    }

    public Collection<ReceiptAction> listAll() {
        Query query = em.createQuery("select a from ReceiptAction a");
        return query.getResultList();
    }

    public ReceiptAction getReceiptActionById(Long id) {
        return em.find(ReceiptAction.class, id);
    }

    public List<ReceiptAction> getReceiptActionByDeliveryNote(String deliveryNote) {
        Query query = em.createQuery("select a from ReceiptAction a where a.deliveryNote = :deliveryNote");
        query.setParameter("deliveryNote", deliveryNote);
        return query.getResultList();
    }
}
