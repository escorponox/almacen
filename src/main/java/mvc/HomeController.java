package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController() {
    }

    @RequestMapping({"/", "/home"})
    public String showHome() {
        return "homeTile";
    }
}
