package mvc;

import forms.ChangePasswordForm;
import forms.CreateUserForm;
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

    private static final String ROLE_TYPES_LIST = "roleTypesList";
    private static final String REDIRECT_USERS_LIST = "redirect:/users?list";

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

        if (user != null) {
            UserEditForm userEditForm = new UserEditForm();
            userEditForm.setId(user.getId());
            userEditForm.setUsername(user.getUsername());
            userEditForm.setEnabled(user.getEnabled());
            userEditForm.setCommission(user.getCommission());
            userEditForm.setRoleTypeEnums(user.getRoleTypesEnums());
            model.addAttribute(ROLE_TYPES_LIST, RoleTypeEnum.asList());
            model.addAttribute(userEditForm);
            return "editUserTile";
        } else {
            return REDIRECT_USERS_LIST;
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "delete")
    public String delete(@RequestParam("delete") Long id) {

        User user = userService.getUserById(id);

        if (user != null) {
            userService.deleteUser(user);
        }
        return REDIRECT_USERS_LIST;
    }

    @RequestMapping(method = RequestMethod.GET, params = "pass")
    public String pass(@RequestParam("pass") Long id, Model model) {
        User user = userService.getUserById(id);

        if (user != null) {
            ChangePasswordForm changePasswordForm = new ChangePasswordForm();
            changePasswordForm.setUserId(user.getId());
            changePasswordForm.setUsername(user.getUsername());
            model.addAttribute(changePasswordForm);
            return "changePasswordTile";
        } else {
            return REDIRECT_USERS_LIST;
        }
    }

    @RequestMapping(method = RequestMethod.GET, params = "newUser")
    public String newUser(Model model) {

        CreateUserForm createUserForm = new CreateUserForm();
        model.addAttribute(createUserForm);
        model.addAttribute(ROLE_TYPES_LIST, RoleTypeEnum.asList());
        return "newUserTile";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@Valid UserEditForm userEditForm, BindingResult bindingResult, Model model) {

        if (!userService.getUserNameAvailabilityChecker().check(userEditForm.getUsername(), userEditForm.getId())) {
            bindingResult.rejectValue("username", "error.user.username", "Username already in use");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute(ROLE_TYPES_LIST, RoleTypeEnum.asList());
            return "editUserTile";
        }

        userService.updateUser(userEditForm);

        return REDIRECT_USERS_LIST;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@Valid ChangePasswordForm changePasswordForm,
                                 BindingResult bindingResult) {

        if (!userService.getPasswordValidator().userExist(changePasswordForm)) {
            bindingResult.reject("error.notValidId", "User not found");
        }

        if (!userService.getPasswordValidator().equalsPasswords(changePasswordForm)) {
            bindingResult.reject("error.passwordsMismatch", "Passwords does not match");
        }

        if (bindingResult.hasErrors()) {
            return "changePasswordTile";
        }

        userService.changePassword(changePasswordForm);

        return REDIRECT_USERS_LIST;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewUser(@Valid CreateUserForm createUserForm, BindingResult bindingResult, Model model) {

        if (!userService.getUserNameAvailabilityChecker().check(createUserForm.getUsername())) {
            bindingResult.rejectValue("username", "error.user.username", "Username already in use");
        }

        if (!userService.getPasswordValidator().equalsPasswords(createUserForm)) {
            bindingResult.rejectValue("repeatPassword", "error.passwordsMismatch", "Passwords does not match");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute(ROLE_TYPES_LIST, RoleTypeEnum.asList());
            return "newUserTile";
        }

        userService.createUser(createUserForm);

        return REDIRECT_USERS_LIST;
    }
}
