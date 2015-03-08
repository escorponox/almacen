package jpa;

import javax.persistence.*;

@Entity
public class Container {
    private Long id;
    private ContainerStatus status;
    private Orders order;
    private OutgoingDocks outgoingDock;

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
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "OUT_DOCK", referencedColumnName = "ID")
    public OutgoingDocks getOutgoingDock() {
        return outgoingDock;
    }

    public void setOutgoingDock(OutgoingDocks outgoingDock) {
        this.outgoingDock = outgoingDock;
    }
}
