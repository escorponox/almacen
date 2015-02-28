package jpa;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLES", schema = "PROYECTO", catalog = "")
public class UserRoles {
    private Long id;
    private String role;
    private Long userId;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE", nullable = false, insertable = true, updatable = true, length = 40)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, precision = -127)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (id != null ? !id.equals(userRoles.id) : userRoles.id != null) return false;
        if (role != null ? !role.equals(userRoles.role) : userRoles.role != null) return false;
        if (userId != null ? !userId.equals(userRoles.userId) : userRoles.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
