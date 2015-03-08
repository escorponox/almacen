package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Providers {
    private Long id;
    private String nif;
    private String name;
    private String address;
    private List<ReceivingOrders> receivingOrdersByProvider;

    @SequenceGenerator(name = "PROVIDERS_SEQ", sequenceName = "PROVIDERS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVIDERS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NIF", nullable = false, insertable = true, updatable = true, length = 9)
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = false, insertable = true, updatable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Providers providers = (Providers) o;

        if (address != null ? !address.equals(providers.address) : providers.address != null) return false;
        if (id != null ? !id.equals(providers.id) : providers.id != null) return false;
        if (name != null ? !name.equals(providers.name) : providers.name != null) return false;
        if (nif != null ? !nif.equals(providers.nif) : providers.nif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "provider")
    public List<ReceivingOrders> getReceivingOrdersByProvider() {
        return receivingOrdersByProvider;
    }

    public void setReceivingOrdersByProvider(List<ReceivingOrders> receivingOrdersByProvider) {
        this.receivingOrdersByProvider = receivingOrdersByProvider;
    }
}
