package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INCOMING_DOCKS", schema = "PROYECTO", catalog = "")
public class IncomingDocks {
    private Long id;
    private String name;
    private List<ReceiptActions> receiptActions;

    @SequenceGenerator(name = "INCOMING_DOCKS_SEQ", sequenceName = "INCOMING_DOCKS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCOMING_DOCKS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncomingDocks that = (IncomingDocks) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "incomingDock")
    public List<ReceiptActions> getReceiptActions() {
        return receiptActions;
    }

    public void setReceiptActions(List<ReceiptActions> receiptActions) {
        this.receiptActions = receiptActions;
    }
}
