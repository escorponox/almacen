package mvc;

import jpa.User;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, params = "list")
    public String list(Model model) {
        model.addAttribute(userService.listAll());
        return "listUsersTile";
    }

    @RequestMapping(method = RequestMethod.GET, params = "edit")
    public String edit(@RequestParam("edit") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("roleTypesList", RoleTypeEnum.asList());
        return "editUserTile";
    }

    @RequestMapping(method = RequestMethod.GET, params = "delete")
    public String delete(@RequestParam("delete") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users?list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(User user, @RequestParam("roleTypes") List<RoleTypeEnum> roleTypes, Model model) {

        userService.updateUser(user, roleTypes);

        return "redirect:/users?list";
    }
}
