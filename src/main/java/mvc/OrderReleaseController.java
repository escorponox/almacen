package mvc;

import forms.OrdersReleaseForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String releaseOrders(@Valid OrdersReleaseForm ordersReleaseForm, BindingResult bindingResult, Model model) {

        orderService.validate(ordersReleaseForm, bindingResult);
        model.addAttribute("docks", orderService.getAllOutgoingDocks());

        if (!bindingResult.hasErrors()) {
            orderService.releaseOrders(ordersReleaseForm);
            return "redirect:/release/";
        }

        return "listReleaseCandidates";
    }
}
