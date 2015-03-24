package mvc;

import forms.OrdersShippingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/ship")
public class OrderShippingController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listOrders(Model model) {

        OrdersShippingForm ordersShippingForm = orderService.getShippingCandidates();

        if (!ordersShippingForm.getOrderShippings().isEmpty()) {
            model.addAttribute(ordersShippingForm);
            return "listShippingCandidates";
        } else {
            return "noShippingCandidates";
        }
    }

    @RequestMapping(value = "/ship", method = RequestMethod.POST)
    public String releaseOrders(@Valid OrdersShippingForm ordersShippingForm, BindingResult bindingResult, Model model) {

        orderService.validate(ordersShippingForm, bindingResult);

        if (!bindingResult.hasErrors()) {
            orderService.shipOrders(ordersShippingForm);
            return "redirect:/ship/";
        }

        return "listShippingCandidates";
    }
}
