package services;

import jpa.User;
import jpa.dao.UserDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.utils.users.UserNameAvailabilityChecker;
import services.utils.users.UserUpdater;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserUpdater userUpdater;
    @Autowired
    private UserNameAvailabilityChecker userNameAvailabilityChecker;

    @Autowired
    private UserDAO userDAO;


    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public void updateUserFromForm(User userFromForm, List<RoleTypeEnum> roleTypes) {

        User savedUser = userDAO.getUserById(userFromForm.getId());

        if (savedUser != null) {
            if (userNameAvailabilityChecker.check(userFromForm, savedUser)) {
                userUpdater.update(userFromForm, roleTypes, savedUser);
            } else {
                //TODO: name not available
            }
        } else {
            //TODO: create new user
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
