package forms;

import jpa.enums.RoleTypeEnum;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class UserEditForm {

    @NotNull(message = "Id is empty")
    private Long id;

    @NotNull(message = "Username is empty")
    @Size(min = 3, message = "Username must be at least 3 charachter long")
    private String username;

    private Boolean enabled;

    @DecimalMin(value = "0", message = "Value must be between 0.00 and 1.00")
    @DecimalMax(value = "1", message = "Value must be between 0.00 and 1.00")
    private BigDecimal commission;

    @NotNull(message = "Give this poor user a role")
    private List<RoleTypeEnum> roleTypeEnums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public List<RoleTypeEnum> getRoleTypeEnums() {
        return roleTypeEnums;
    }

    public void setRoleTypeEnums(List<RoleTypeEnum> roleTypeEnums) {
        this.roleTypeEnums = roleTypeEnums;
    }
}
