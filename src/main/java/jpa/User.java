package jpa;

import jpa.enums.RoleTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -8080846075636160244L;

    private Long id;
    private String username;
    private String password;
    private Boolean enabled;
    private BigDecimal commission;
    private String eMail;
    private List<Order> ordersBySeller;
    private List<UserRole> userRoleById;

    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, precision = -127)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ENABLED", nullable = false, insertable = true, updatable = true, precision = 0)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "COMMISSION", nullable = true, insertable = true, updatable = true, precision = -127)
    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, insertable = true, updatable = true, length = 100)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(commission != null ? !commission.equals(user.commission) : user.commission != null)
                && !(enabled != null ? !enabled.equals(user.enabled) : user.enabled != null)
                && !(id != null ? !id.equals(user.id) : user.id != null)
                && !(password != null ? !password.equals(user.password) : user.password != null)
                && !(username != null ? !username.equals(user.username) : user.username != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "seller")
    public List<Order> getOrdersBySeller() {
        return ordersBySeller;
    }

    public void setOrdersBySeller(List<Order> ordersBySeller) {
        this.ordersBySeller = ordersBySeller;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public List<UserRole> getUserRoleById() {
        return userRoleById;
    }

    public void setUserRoleById(List<UserRole> userRoleById) {
        this.userRoleById = userRoleById;
    }

    @Transient
    public List<RoleTypeEnum> getRoleTypesEnums() {
        List<RoleTypeEnum> roleTypes = new LinkedList<>();
        for (UserRole userRole : getUserRoleById()) {
            roleTypes.add(userRole.getRole().getRole());
        }
        return roleTypes;
    }

    public void setRoleTypesEnums(List<RoleTypeEnum> roleTypes) {

        //Needed for Spring MVC
    }

}
