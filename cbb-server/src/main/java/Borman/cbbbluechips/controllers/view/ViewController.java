package Borman.cbbbluechips.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({
            "/",
            "/portfolio",
            "/market",
            "/trade",
            "/trade/*",
            "/calculator",
            "/transactions",
            "/rules",
            "/leaderboard"
    })
    public String getView() {
        return "index";
    }

}