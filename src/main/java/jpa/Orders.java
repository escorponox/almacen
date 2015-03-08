package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    private Long id;
    private Long code;
    private Date createdAt;
    private Date updatedAt;
    private Clients client;
    private OrdersStatus status;
    private Users seller;
    private List<OrdersLines> orderLines;
    private List<PickingActions> pickingActionsesById;

    @SequenceGenerator(name = "ORDERS_SEQ", sequenceName = "ORDERS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODE", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Basic
    @Column(name = "CREATED_AT", nullable = false, insertable = true, updatable = true)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "UPDATED_AT", nullable = false, insertable = true, updatable = true)
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (code != null ? !code.equals(orders.code) : orders.code != null) return false;
        if (createdAt != null ? !createdAt.equals(orders.createdAt) : orders.createdAt != null) return false;
        if (id != null ? !id.equals(orders.id) : orders.id != null) return false;
        if (updatedAt != null ? !updatedAt.equals(orders.updatedAt) : orders.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", nullable = false)
    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public OrdersStatus getStatus() {
        return status;
    }

    public void setStatus(OrdersStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "SELLER_ID", referencedColumnName = "ID", nullable = false)
    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    @OneToMany(mappedBy = "order")
    public List<OrdersLines> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrdersLines> orderLines) {
        this.orderLines = orderLines;
    }

    @OneToMany(mappedBy = "order")
    public List<PickingActions> getPickingActionsesById() {
        return pickingActionsesById;
    }

    public void setPickingActionsesById(List<PickingActions> pickingActionsesById) {
        this.pickingActionsesById = pickingActionsesById;
    }
}
