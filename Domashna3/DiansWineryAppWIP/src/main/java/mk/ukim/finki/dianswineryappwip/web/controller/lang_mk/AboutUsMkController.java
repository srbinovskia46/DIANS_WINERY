package mk.ukim.finki.dianswineryappwip.web.controller.lang_mk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsMkController {

    @GetMapping("/aboutUs_mkd")
    public String aboutUsMk() {
        return "lang_mk/aboutUs_mkd";
    }
}