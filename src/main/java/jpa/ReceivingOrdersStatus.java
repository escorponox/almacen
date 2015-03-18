package jpa;

import jpa.enums.ReceivingOrdersStatusEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECEIVING_ORDERS_STATUS", schema = "PROYECTO", catalog = "")
public class ReceivingOrdersStatus implements Serializable {

    private static final long serialVersionUID = -1884407321085835462L;

    private Long id;
    private ReceivingOrdersStatusEnum status;
    private String description;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, insertable = true, updatable = true, length = 20)
    public ReceivingOrdersStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReceivingOrdersStatusEnum status) {
        this.status = status;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceivingOrdersStatus that = (ReceivingOrdersStatus) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
