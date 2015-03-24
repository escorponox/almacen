package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.ItemService;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listOrders(Model model) {

        String items = itemService.listAllItemsXml();

        model.addAttribute("xmlItems", items);

        return "itemsList";
    }
}
