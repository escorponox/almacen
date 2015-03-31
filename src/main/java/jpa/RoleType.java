package jpa;

import jpa.enums.RoleTypeEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROLE_TYPE", catalog = "")
public class RoleType implements Serializable {

    private static final long serialVersionUID = 577848716400118633L;

    private Long id;
    private RoleTypeEnum role;
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
    @Column(name = "ROLE", nullable = false, insertable = true, updatable = true, length = 20)
    public RoleTypeEnum getRole() {
        return role;
    }

    public void setRole(RoleTypeEnum role) {
        this.role = role;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 20)
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

        RoleType roleType = (RoleType) o;

        if (description != null ? !description.equals(roleType.description) : roleType.description != null)
            return false;
        if (id != null ? !id.equals(roleType.id) : roleType.id != null) return false;
        if (role != null ? !role.equals(roleType.role) : roleType.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
