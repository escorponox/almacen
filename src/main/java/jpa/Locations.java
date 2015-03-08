package jpa;

import javax.persistence.*;

@Entity
public class Locations {
    private Long id;
    private String corridor;
    private String side;
    private String module;
    private String name;
    private Long seq;

    @SequenceGenerator(name = "LOCATIONS_SEQ", sequenceName = "LOCATIONS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATIONS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CORRIDOR", nullable = false, insertable = true, updatable = true, length = 3)
    public String getCorridor() {
        return corridor;
    }

    public void setCorridor(String corridor) {
        this.corridor = corridor;
    }

    @Basic
    @Column(name = "SIDE", nullable = false, insertable = true, updatable = true, length = 1)
    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    @Basic
    @Column(name = "MODULE", nullable = false, insertable = true, updatable = true, length = 3)
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SEQ", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (corridor != null ? !corridor.equals(locations.corridor) : locations.corridor != null) return false;
        if (id != null ? !id.equals(locations.id) : locations.id != null) return false;
        if (module != null ? !module.equals(locations.module) : locations.module != null) return false;
        if (name != null ? !name.equals(locations.name) : locations.name != null) return false;
        if (seq != null ? !seq.equals(locations.seq) : locations.seq != null) return false;
        if (side != null ? !side.equals(locations.side) : locations.side != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (corridor != null ? corridor.hashCode() : 0);
        result = 31 * result + (side != null ? side.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        return result;
    }
}
