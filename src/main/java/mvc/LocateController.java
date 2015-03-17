package mvc;

import forms.LocateActionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.LocateService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/locate")
public class LocateController {

    @Autowired
    private LocateService locateService;

    @RequestMapping(value = {"/", "/assign"}, method = RequestMethod.GET)
    public String assignAction(Model model, Principal principal) {

        LocateActionForm locateActionForm = locateService.assignLocateAction(principal.getName());

        if (locateActionForm == null) {
            return "noLocateActions";
        } else {
            model.addAttribute(locateActionForm);
            return "locate";
        }
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String createReceiptForm(@Valid LocateActionForm locateActionForm, BindingResult bindingResult, Model model) {

        locateService.validate(locateActionForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "locate";
        }

        locateService.confirmLocate(locateActionForm);

        return "redirect:/locate/";
    }
}
