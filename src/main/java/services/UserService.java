package services;

import forms.ChangePasswordForm;
import forms.CreateUserForm;
import jpa.User;
import jpa.dao.UserDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.utils.users.*;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserCreator userCreator;
    @Autowired
    private UserUpdater userUpdater;
    @Autowired
    private UserPasswordUpdater userPasswordUpdater;
    @Autowired
    private UserNameAvailabilityChecker userNameAvailabilityChecker;
    @Autowired
    private PasswordValidator passwordValidator;

    @Autowired
    private UserDAO userDAO;


    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public void createUser(CreateUserForm createUserForm) {

        userCreator.create(createUserForm);
    }

    //TODO: Refactor. Create a editUserForm and return Boolean
    public void updateUser(User userFromForm, List<RoleTypeEnum> roleTypes) {

        User savedUser = userDAO.getUserById(userFromForm.getId());

        if (savedUser != null) {
            userUpdater.update(userFromForm, roleTypes, savedUser);
        } else {
            //TODO: userCreator.create(userFromForm, roleTypes);
        }
    }

    public void changePassword(ChangePasswordForm changePasswordForm) {

        User savedUser = userDAO.getUserById(changePasswordForm.getUserId());
        if (savedUser != null) {
            userPasswordUpdater.update(savedUser, changePasswordForm.getNewPassword());
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

    public UserNameAvailabilityChecker getUserNameAvailabilityChecker() {
        return userNameAvailabilityChecker;
    }

    public PasswordValidator getPasswordValidator() {
        return passwordValidator;
    }

}
