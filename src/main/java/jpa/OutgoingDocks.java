package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OUTGOING_DOCKS", schema = "PROYECTO", catalog = "")
public class OutgoingDocks {
    private Long id;
    private String name;
    private List<Container> containersById;

    @SequenceGenerator(name = "OUTGOING_DOCKS_SEQ", sequenceName = "OUTGOING_DOCKS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OUTGOING_DOCKS_SEQ")
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

        OutgoingDocks that = (OutgoingDocks) o;

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

    @OneToMany(mappedBy = "outgoingDock")
    public List<Container> getContainersById() {
        return containersById;
    }

    public void setContainersById(List<Container> containersById) {
        this.containersById = containersById;
    }
}
