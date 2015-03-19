package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    private static final long serialVersionUID = -83446756335127508L;

    private Long id;
    private Long code;
    private Date createdAt;
    private Date updatedAt;
    private Customer customer;
    private OrdersStatus status;
    private User seller;
    private List<OrderLine> orderLines;

    public Order() {
        orderLines = new LinkedList<>();
    }

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @SequenceGenerator(name = "ORDERS_SEQ", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_CODE_SEQ")
    @SequenceGenerator(name = "ORDERS_CODE_SEQ", sequenceName = "ORDERS_CODE_SEQ", allocationSize = 1)
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
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    @Transient
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Transient
    public BigDecimal getTotalAmount() {

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderLine orderLine : orderLines) {
            totalAmount = totalAmount.add(orderLine.getItem().getPrice().multiply(BigDecimal.valueOf(orderLine.getOrderedQuantity())));
        }

        return totalAmount;
    }
}
