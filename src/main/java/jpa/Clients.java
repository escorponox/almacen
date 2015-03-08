package jpa;

import javax.persistence.*;

@Entity
public class Clients {
    private Long id;
    private String nif;
    private String name;
    private String address;
    private OutgoingDocks outgoingDock;

    @SequenceGenerator(name = "CLIENTS_SEQ", sequenceName = "CLIENTS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTS_SEQ")
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

        Clients clients = (Clients) o;

        if (address != null ? !address.equals(clients.address) : clients.address != null) return false;
        if (id != null ? !id.equals(clients.id) : clients.id != null) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (nif != null ? !nif.equals(clients.nif) : clients.nif != null) return false;

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

    @ManyToOne
    @JoinColumn(name = "DEFAULT_DOCK", referencedColumnName = "ID")
    public OutgoingDocks getOutgoingDock() {
        return outgoingDock;
    }

    public void setOutgoingDock(OutgoingDocks outgoingDock) {
        this.outgoingDock = outgoingDock;
    }
}
