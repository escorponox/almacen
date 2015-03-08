package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECEIPT_ACTIONS", schema = "PROYECTO", catalog = "")
public class ReceiptActions {
    private Long id;
    private String deliveryNote;
    private Long recQuantity;
    private Date receivedAt;
    private List<LocateActions> locateActions;
    private IncomingDocks incomingDock;
    private ReceivingOrders receivingOrder;
    private ReceivingOrdersLines receivingOrdersLine;
    private Users picker;

    @SequenceGenerator(name = "RECEIPT_ACTIONS_SEQ", sequenceName = "RECEIPT_ACTIONS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIPT_ACTIONS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DELIVERY_NOTE", nullable = false, insertable = true, updatable = true, length = 100)
    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    @Basic
    @Column(name = "REC_QUANTITY", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getRecQuantity() {
        return recQuantity;
    }

    public void setRecQuantity(Long recQuantity) {
        this.recQuantity = recQuantity;
    }

    @Basic
    @Column(name = "RECEIVED_AT", nullable = false, insertable = true, updatable = true)
    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptActions that = (ReceiptActions) o;

        if (deliveryNote != null ? !deliveryNote.equals(that.deliveryNote) : that.deliveryNote != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recQuantity != null ? !recQuantity.equals(that.recQuantity) : that.recQuantity != null) return false;
        if (receivedAt != null ? !receivedAt.equals(that.receivedAt) : that.receivedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (deliveryNote != null ? deliveryNote.hashCode() : 0);
        result = 31 * result + (recQuantity != null ? recQuantity.hashCode() : 0);
        result = 31 * result + (receivedAt != null ? receivedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "receiptActionsByReceiptActionId")
    public List<LocateActions> getLocateActions() {
        return locateActions;
    }

    public void setLocateActions(List<LocateActions> locateActions) {
        this.locateActions = locateActions;
    }

    @ManyToOne
    @JoinColumn(name = "DOCK_ID", referencedColumnName = "ID", nullable = false)
    public IncomingDocks getIncomingDock() {
        return incomingDock;
    }

    public void setIncomingDock(IncomingDocks incomingDock) {
        this.incomingDock = incomingDock;
    }

    @ManyToOne
    @JoinColumn(name = "REC_ORDER_ID", referencedColumnName = "ID", nullable = false)
    public ReceivingOrders getReceivingOrder() {
        return receivingOrder;
    }

    public void setReceivingOrder(ReceivingOrders receivingOrder) {
        this.receivingOrder = receivingOrder;
    }

    @ManyToOne
    @JoinColumn(name = "REC_ORDER_LINE_ID", referencedColumnName = "ID", nullable = false)
    public ReceivingOrdersLines getReceivingOrdersLine() {
        return receivingOrdersLine;
    }

    public void setReceivingOrdersLine(ReceivingOrdersLines receivingOrdersLine) {
        this.receivingOrdersLine = receivingOrdersLine;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public Users getPicker() {
        return picker;
    }

    public void setPicker(Users picker) {
        this.picker = picker;
    }
}
