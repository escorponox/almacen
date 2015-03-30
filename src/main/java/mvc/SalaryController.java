package mvc;

import forms.SelectMonthForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    private static final Map<Integer, String> MONTHS = new LinkedHashMap() {
        {
            put(1, "JANUARY");
            put(2, "FEBRUARY");
            put(3, "MARCH");
            put(4, "APRIL");
            put(5, "MAY");
            put(6, "JUNE");
            put(7, "JULY");
            put(8, "AUGUST");
            put(9, "SEPTEMBER");
            put(10, "OCTOBER");
            put(11, "NOVEMBER");
            put(12, "DECEMBER");
        }
    };

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String select(Model model) {

        model.addAttribute("months", MONTHS);
        return "selectMonth";
    }

    @RequestMapping(value = "/show")
    public String calculate(@Valid SelectMonthForm selectMonthForm, BindingResult bindingResult) {
        return "showSalary";
    }

}
