package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.OrderService;
import services.domain.FillItemDataResponse;

import java.util.List;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/itemCodeAutocomplete", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getItemCodes(@RequestParam String tagName) {
        return orderService.searchItemCodes(tagName);
    }

    @RequestMapping(value = "/fillItemData", method = RequestMethod.GET)
    public
    @ResponseBody
    FillItemDataResponse getItemData(@RequestParam(value = "itemcode") String itemCode) {

        return orderService.fillItemData(itemCode);
    }
}
