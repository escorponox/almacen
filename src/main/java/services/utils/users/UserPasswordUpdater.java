package services.utils.users;

import jpa.User;
import jpa.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserPasswordUpdater {

    @Autowired
    private UserDAO userDAO;

    public void update(User user, String password) {

        String hashedPassword = new BCryptPasswordEncoder().encode(password);
        user.setPassword(hashedPassword);
        userDAO.updateUser(user);
    }
}
