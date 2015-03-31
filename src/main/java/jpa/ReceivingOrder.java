package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECEIVING_ORDERS", catalog = "")
public class ReceivingOrder implements Serializable {

    private static final long serialVersionUID = 5848272190271297574L;

    private BigDecimal id;
    private Long code;
    private Date createdAt;
    private Date updatedAt;
    private Provider provider;
    private ReceivingOrdersStatus status;
    private List<ReceivingOrderLine> receivingOrderLinesByOrder;

    @SequenceGenerator(name = "RECEIVING_ORDERS_SEQ", sequenceName = "RECEIVING_ORDERS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEIVING_ORDERS_SEQ")
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

        ReceivingOrder that = (ReceivingOrder) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

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
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID", nullable = false)
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public ReceivingOrdersStatus getStatus() {
        return status;
    }

    public void setStatus(ReceivingOrdersStatus status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "receivingOrder")
    public List<ReceivingOrderLine> getReceivingOrderLinesByOrder() {
        return receivingOrderLinesByOrder;
    }

    public void setReceivingOrderLinesByOrder(List<ReceivingOrderLine> receivingOrderLinesByOrder) {
        this.receivingOrderLinesByOrder = receivingOrderLinesByOrder;
    }
}
