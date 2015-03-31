package mvc;

import forms.SelectMonthForm;
import forms.ShowSalaryForm;
import jpa.User;
import jpa.enums.RoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.SalaryService;
import services.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private UserService userService;
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String select(Principal principal) {

        User user = userService.getUserByUsername(principal.getName());

        if (user.getRoleTypesEnums().contains(RoleTypeEnum.ROLE_SELLER) && user.getCommission() != null) {
            return "selectMonth";
        } else {
            return "noSellerOrCommission";
        }

    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String calculate(@Valid SelectMonthForm selectMonthForm, BindingResult bindingResult, Model model, Principal principal) {


        if(bindingResult.hasErrors()) {
            return "selectMonth";
        }

        ShowSalaryForm showSalaryForm = salaryService.calculateSalary(selectMonthForm, principal.getName());
        model.addAttribute(showSalaryForm);

        return "showSalary";
    }

}
