package jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_ROLES", schema = "PROYECTO", catalog = "")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 5336557307026547512L;

    private Long id;
    private RoleType role;
    private User user;

    @SequenceGenerator(name = "USER_ROLES_SEQ", sequenceName = "USER_ROLES_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ROLES_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (!role.equals(userRole.role)) return false;
        if (!user.equals(userRole.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = role.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ROLE", referencedColumnName = "ID", nullable = false)
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
