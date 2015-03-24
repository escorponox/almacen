package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Container implements Serializable {

    private static final long serialVersionUID = -5450796839195421634L;

    private Long id;
    private ContainerStatus status;
    private Order order;
    private OutgoingDock outgoingDock;
    private User picker;

    @SequenceGenerator(name = "CONTAINER_SEQ", sequenceName = "CONTAINER_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTAINER_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (id != null ? !id.equals(container.id) : container.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public ContainerStatus getStatus() {
        return status;
    }

    public void setStatus(ContainerStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "OUT_DOCK", referencedColumnName = "ID")
    public OutgoingDock getOutgoingDock() {
        return outgoingDock;
    }

    public void setOutgoingDock(OutgoingDock outgoingDock) {
        this.outgoingDock = outgoingDock;
    }

    @ManyToOne
    @JoinColumn(name = "PICKER", referencedColumnName = "ID")
    public User getPicker() {
        return picker;
    }

    public void setPicker(User picker) {
        this.picker = picker;
    }
}
