package services.utils.users;

import forms.CreateUserForm;
import jpa.User;
import jpa.UserRole;
import jpa.dao.RoleTypeDAO;
import jpa.dao.UserDAO;
import jpa.dao.UserRoleDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserCreator {

    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleTypeDAO roleTypeDAO;
    @Autowired
    private UserDAO userDAO;

    public void create(CreateUserForm createUserForm) {

        User newUser = new User();
        newUser.setUsername(createUserForm.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(createUserForm.getPassword()));
        newUser.setEnabled(createUserForm.getEnabled());
        newUser.setCommission(createUserForm.getCommission());

        userDAO.addUser(newUser);

        for (RoleTypeEnum roleTypeEnum : createUserForm.getRoleTypeEnums()) {
            UserRole userRole = new UserRole();
            userRole.setRole(roleTypeDAO.getRoleTypeByRole(roleTypeEnum));
            userRole.setUser(newUser);
            userRoleDAO.addUserRole(userRole);
        }
    }
}
