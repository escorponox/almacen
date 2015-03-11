package services;

import jpa.User;
import jpa.dao.UserDAO;
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

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public void updateUser(User user, List<RoleTypeEnum> roleTypes) {
        //TODO
    }

    public Collection<User> listAll() {
        return userDAO.listAll();
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

}
