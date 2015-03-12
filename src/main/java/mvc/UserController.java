package mvc;

import forms.UserEditForm;
import jpa.User;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.UserService;

import javax.validation.Valid;

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
        UserEditForm userEditForm = new UserEditForm();
        userEditForm.setUser(user);
        userEditForm.setRoleTypeEnums(user.getRoleTypesEnums());
        model.addAttribute("roleTypesList", RoleTypeEnum.asList());
        model.addAttribute(userEditForm);
        return "editUserTile";
    }

    @RequestMapping(method = RequestMethod.GET, params = "delete")
    public String delete(@RequestParam("delete") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users?list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid UserEditForm userEditForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("roleTypesList", RoleTypeEnum.asList());
//            model.addAttribute("user", userEditForm);
            return "editUserTile";
        }

        userService.updateUserFromForm(userEditForm.getUser(), userEditForm.getRoleTypeEnums());
//        userService.addUser(user);

        return "redirect:/users?list";
    }
}
