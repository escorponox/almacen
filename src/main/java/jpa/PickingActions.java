package jpa;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PICKING_ACTIONS", schema = "PROYECTO", catalog = "")
public class PickingActions {
    private Long id;
    private BigDecimal ordered;
    private BigDecimal picked;
    private Long seq;
    private ActionStatus status;
    private Container container;
    private Orders order;
    private OrdersLines orderLine;
    private OutgoingDocks outgoingDock;
    private Users picker;

    @SequenceGenerator(name = "PICKING_ACTIONS_SEQ", sequenceName = "PICKING_ACTIONS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PICKING_ACTIONS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORDERED", nullable = false, insertable = true, updatable = true, precision = -127)
    public BigDecimal getOrdered() {
        return ordered;
    }

    public void setOrdered(BigDecimal ordered) {
        this.ordered = ordered;
    }

    @Basic
    @Column(name = "PICKED", nullable = true, insertable = true, updatable = true, precision = -127)
    public BigDecimal getPicked() {
        return picked;
    }

    public void setPicked(BigDecimal picked) {
        this.picked = picked;
    }

    @Basic
    @Column(name = "SEQ", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PickingActions that = (PickingActions) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ordered != null ? !ordered.equals(that.ordered) : that.ordered != null) return false;
        if (picked != null ? !picked.equals(that.picked) : that.picked != null) return false;
        if (seq != null ? !seq.equals(that.seq) : that.seq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ordered != null ? ordered.hashCode() : 0);
        result = 31 * result + (picked != null ? picked.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public ActionStatus getStatus() {
        return status;
    }

    public void setStatus(ActionStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "CONTAINER_ID", referencedColumnName = "ID", nullable = false)
    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "LINE_ID", referencedColumnName = "ID", nullable = false)
    public OrdersLines getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrdersLines orderLine) {
        this.orderLine = orderLine;
    }

    @ManyToOne
    @JoinColumn(name = "OUT_DOCK", referencedColumnName = "ID", nullable = false)
    public OutgoingDocks getOutgoingDock() {
        return outgoingDock;
    }

    public void setOutgoingDock(OutgoingDocks outgoingDock) {
        this.outgoingDock = outgoingDock;
    }

    @ManyToOne
    @JoinColumn(name = "PICKER_ID", referencedColumnName = "ID")
    public Users getPicker() {
        return picker;
    }

    public void setPicker(Users picker) {
        this.picker = picker;
    }
}
