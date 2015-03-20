package services;

import forms.ChangePasswordForm;
import forms.CreateUserForm;
import forms.UserEditForm;
import jpa.User;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.utils.users.*;

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

    public void updateUser(UserEditForm userEditForm) {

        User savedUser = userDAO.getUserById(userEditForm.getId());

        if (savedUser != null) {
            userUpdater.update(userEditForm, savedUser);
        }
    }

    public void changePassword(ChangePasswordForm changePasswordForm) {

        User savedUser = userDAO.getUserById(changePasswordForm.getUserId());

        if (savedUser != null) {
            userPasswordUpdater.update(savedUser, changePasswordForm.getNewPassword());
        }
    }


    public List<User> listAll() {
        return userDAO.listAll();
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public UserNameAvailabilityChecker getUserNameAvailabilityChecker() {
        return userNameAvailabilityChecker;
    }

    public PasswordValidator getPasswordValidator() {
        return passwordValidator;
    }

}
