package mvc;

import forms.OrderRelease;
import forms.OrdersReleaseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/release")
public class OrderReleaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listOrders(Model model) {

        OrdersReleaseForm orderReleaseForm = orderService.getReleaseCandidates();

        if (orderReleaseForm.getOrderReleases().size() > 0) {
            model.addAttribute(orderReleaseForm);
            model.addAttribute("docks", orderService.getAllOutgoingDocks());
            return "listReleaseCandidates";
        } else {
            return "noReleaseCandidates";
        }
    }

    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public String releaseOrders(@Valid OrderRelease orderReleaseForm) {

        return null;
    }
}
