package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECEIVING_ORDERS_LINES", schema = "PROYECTO", catalog = "")
public class ReceivingOrderLine implements Serializable {

    private static final long serialVersionUID = -8924715349127650498L;

    private Long id;
    private Integer lineNumber;
    private Long orderedQuantity;
    private Long pendingQuantity;
    private Item item;
    private ReceivingOrder receivingOrder;

    @SequenceGenerator(name = "RECEIVING_ORDERS_LINES_SEQ", sequenceName = "RECEIVING_ORDERS_LINES_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIVING_ORDERS_LINES_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LINE_NUMBER", nullable = false, insertable = true, updatable = true, precision = -127)
    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Basic
    @Column(name = "ORDERED_QUANTITY", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Long orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    @Basic
    @Column(name = "PENDING_QUANTITY", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(Long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceivingOrderLine that = (ReceivingOrderLine) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lineNumber != null ? !lineNumber.equals(that.lineNumber) : that.lineNumber != null) return false;
        if (orderedQuantity != null ? !orderedQuantity.equals(that.orderedQuantity) : that.orderedQuantity != null)
            return false;
        if (pendingQuantity != null ? !pendingQuantity.equals(that.pendingQuantity) : that.pendingQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lineNumber != null ? lineNumber.hashCode() : 0);
        result = 31 * result + (orderedQuantity != null ? orderedQuantity.hashCode() : 0);
        result = 31 * result + (pendingQuantity != null ? pendingQuantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    public ReceivingOrder getReceivingOrder() {
        return receivingOrder;
    }

    public void setReceivingOrder(ReceivingOrder receivingOrder) {
        this.receivingOrder = receivingOrder;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
