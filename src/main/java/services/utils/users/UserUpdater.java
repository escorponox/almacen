package services.utils.users;

import jpa.User;
import jpa.UserRole;
import jpa.dao.RoleTypeDAO;
import jpa.dao.UserDAO;
import jpa.dao.UserRoleDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserUpdater {

    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleTypeDAO roleTypeDAO;
    @Autowired
    private UserDAO userDAO;

    public void update(User modifiedUser, List<RoleTypeEnum> roleTypes, User savedUser) {
        savedUser.setUsername(modifiedUser.getUsername());
        savedUser.setEnabled(modifiedUser.getEnabled());
        savedUser.setCommission(modifiedUser.getCommission());

        List<RoleTypeEnum> roleTypesToRemove = savedUser.getRoleTypesEnums();
        roleTypesToRemove.removeAll(roleTypes);

        roleTypes.removeAll(savedUser.getRoleTypesEnums());
        for (RoleTypeEnum roleType : roleTypes) {
            UserRole userRole = new UserRole();
            userRole.setRole(roleTypeDAO.getRoleTypeByRole(roleType));
            userRole.setUser(savedUser);
            userRoleDAO.addUserRole(userRole);
        }

        for (RoleTypeEnum roleTypeEnum : roleTypesToRemove) {
            UserRole roleToRemove = userRoleDAO.getUserRoleByUserAndRoleTypeEnum(savedUser, roleTypeEnum);
            userRoleDAO.deleteUserRole(roleToRemove);
        }

        userDAO.updateUser(savedUser);
    }
}
