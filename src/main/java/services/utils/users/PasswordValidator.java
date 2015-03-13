package services.utils.users;

import forms.ChangePasswordForm;
import forms.CreateUserForm;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    @Autowired
    private UserDAO userDAO;

    public Boolean userExist(ChangePasswordForm changePasswordForm) {
        return userDAO.getUserById(changePasswordForm.getUserId()) != null;
    }

    public Boolean equalsPasswords(ChangePasswordForm changePasswordForm) {
        return changePasswordForm.getNewPassword().equals(changePasswordForm.getRepeatPassword());
    }

    public Boolean equalsPasswords(CreateUserForm createUserForm) {
        return createUserForm.getPassword().equals(createUserForm.getRepeatPassword());
    }
}
