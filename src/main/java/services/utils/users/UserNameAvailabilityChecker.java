package services.utils.users;

import jpa.User;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameAvailabilityChecker {

    @Autowired
    private UserDAO userDAO;

    public Boolean check(User modifiedUser, User savedUser) {

        User existingUserByName = userDAO.getUserByUsername(modifiedUser.getUsername());
        return !(existingUserByName != null && !existingUserByName.equals(savedUser));
    }

}
