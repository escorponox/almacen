package services.utils.users;

import jpa.User;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNameAvailabilityChecker {

    @Autowired
    private UserDAO userDAO;

    public Boolean check(String username, Long editedUserId) {

        User savedUser = userDAO.getUserById(editedUserId);

        User existingUserByName = userDAO.getUserByUsername(username);
        return !(existingUserByName != null && !existingUserByName.equals(savedUser));
    }

    public Boolean check(String username) {

        User existingUserByName = userDAO.getUserByUsername(username);
        return existingUserByName == null;
    }

}
