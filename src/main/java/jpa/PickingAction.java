package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PICKING_ACTIONS", schema = "PROYECTO", catalog = "")
public class PickingAction implements Serializable {

    private static final long serialVersionUID = 4996012426970191390L;

    private Long id;
    private Integer ordered;
    private Integer picked;
    private Long seq;
    private ActionStatus status;
    private Container container;
    private OrderLine orderLine;
    private OutgoingDock outgoingDock;
    private User picker;

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
    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    @Basic
    @Column(name = "PICKED", nullable = true, insertable = true, updatable = true, precision = -127)
    public Integer getPicked() {
        return picked;
    }

    public void setPicked(Integer picked) {
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

        PickingAction that = (PickingAction) o;

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
    @JoinColumn(name = "LINE_ID", referencedColumnName = "ID", nullable = false)
    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    @ManyToOne
    @JoinColumn(name = "OUT_DOCK", referencedColumnName = "ID", nullable = false)
    public OutgoingDock getOutgoingDock() {
        return outgoingDock;
    }

    public void setOutgoingDock(OutgoingDock outgoingDock) {
        this.outgoingDock = outgoingDock;
    }

    @ManyToOne
    @JoinColumn(name = "PICKER_ID", referencedColumnName = "ID")
    public User getPicker() {
        return picker;
    }

    public void setPicker(User picker) {
        this.picker = picker;
    }
}
