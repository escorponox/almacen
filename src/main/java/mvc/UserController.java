package mvc;

import jpa.User;
import jpa.dao.UserDAO;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET, params = "list")
    public String list(Model model) {
        model.addAttribute(userDAO.listAll());
        return "listUsersTile";
    }

    @RequestMapping(method = RequestMethod.GET, params = "edit")
    public String edit(@RequestParam("edit") Long id, Model model) {
        User user = userDAO.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roleTypesList", RoleTypeEnum.asList());
        return "editUserTile";
    }

    @RequestMapping(method = RequestMethod.GET, params = "delete")
    public String delete(@RequestParam("delete") Long id) {
        User user = userDAO.getUserById(id);
        userDAO.deleteUser(user);
        return "redirect:/users?list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestParam("user") User user, Model model) {
        User user2 = userDAO.getUserById(1L);
        return null;
    }
}
