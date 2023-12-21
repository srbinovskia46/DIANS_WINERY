package mk.ukim.finki.dianswineryappwip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {

    @GetMapping
    public String getAboutUsPage() {
        return "aboutUs";
    }
}
