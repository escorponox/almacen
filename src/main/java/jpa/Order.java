package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    private Long id;
    private Long code;
    private Date createdAt;
    private Date updatedAt;
    private Client client;
    private OrdersStatus status;
    private User seller;
    private List<OrderLine> orderLines;
    private List<PickingAction> pickingActions;

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

        Order order = (Order) o;

        if (code != null ? !code.equals(order.code) : order.code != null) return false;
        if (createdAt != null ? !createdAt.equals(order.createdAt) : order.createdAt != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (updatedAt != null ? !updatedAt.equals(order.updatedAt) : order.updatedAt != null) return false;

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
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
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
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @OneToMany(mappedBy = "order")
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @OneToMany(mappedBy = "order")
    public List<PickingAction> getPickingActions() {
        return pickingActions;
    }

    public void setPickingActions(List<PickingAction> pickingActionsesById) {
        this.pickingActions = pickingActionsesById;
    }
}
