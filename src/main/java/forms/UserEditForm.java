package forms;

import jpa.User;
import jpa.enums.RoleTypeEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserEditForm {

    @NotNull(message = "Not Valid User")
    @Valid
    private User user;

    @NotNull(message = "Give this poor user a role")
    private List<RoleTypeEnum> roleTypeEnums;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoleTypeEnum> getRoleTypeEnums() {
        return roleTypeEnums;
    }

    public void setRoleTypeEnums(List<RoleTypeEnum> roleTypeEnums) {
        this.roleTypeEnums = roleTypeEnums;
    }
}
