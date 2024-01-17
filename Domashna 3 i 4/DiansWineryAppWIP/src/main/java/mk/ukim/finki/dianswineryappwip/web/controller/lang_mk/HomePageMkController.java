package mk.ukim.finki.dianswineryappwip.web.controller.lang_mk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageMkController {

    @GetMapping("/home_mk")
    public String homeMk() {
        return "lang_mk/home-page_mkd";
    }
}