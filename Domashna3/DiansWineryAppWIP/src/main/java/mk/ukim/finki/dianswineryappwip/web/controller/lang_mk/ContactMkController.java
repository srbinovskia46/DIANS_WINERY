package mk.ukim.finki.dianswineryappwip.web.controller.lang_mk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactMkController {

    @GetMapping("/contact_mkd")
    public String contactMk() {
        return "lang_mk/contact_mkd";
    }
}