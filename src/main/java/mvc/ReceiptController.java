package mvc;

import forms.ReceiptForm;
import forms.ReceiptSelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.ReceiptService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @RequestMapping(value = {"/", "/select"}, method = RequestMethod.GET)
    public String selectReceipt(Model model) {

        ReceiptSelectForm receiptSelectForm = new ReceiptSelectForm();
        model.addAttribute(receiptSelectForm);
        model.addAttribute("docks", receiptService.getAllIncomingDocks());
        return "selectReceiptTile";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String createReceiptForm(@Valid ReceiptSelectForm receiptSelectForm, BindingResult bindingResult, Model model) {

        receiptService.validate(receiptSelectForm, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("docks", receiptService.getAllIncomingDocks());
            return "selectReceiptTile";
        }

        ReceiptForm receiptForm = receiptService.createReceipt(receiptSelectForm);
        model.addAttribute(receiptForm);

        return "receiptTile";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createReceipt(@Valid ReceiptForm receiptForm, BindingResult bindingResult, Model model, Principal principal) {

        receiptService.validate(receiptForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "receiptTile";
        }

        receiptService.createReceiptActions(receiptForm, principal.getName());

        return "redirect:/receipt/";
    }


}
