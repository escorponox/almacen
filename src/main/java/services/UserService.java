package services;

import jpa.User;
import jpa.UserRole;
import jpa.dao.RoleTypeDAO;
import jpa.dao.UserDAO;
import jpa.dao.UserRoleDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleTypeDAO roleTypeDAO;

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public void updateUserFromForm(User user, List<RoleTypeEnum> roleTypes) {

        User savedUser = userDAO.getUserById(user.getId());

        if (savedUser != null) {
            if (user.getUsername().equals(savedUser.getUsername())) {
                savedUser.setEnabled(user.getEnabled());
                savedUser.setCommission(user.getCommission());

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
    }

    public Collection<User> listAll() {
        return userDAO.listAll();
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
