package mk.ukim.finki.dianswineryappwip.web.controller;

import mk.ukim.finki.dianswineryappwip.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {
    private final WineryService wineryService;

    public HomeController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @RequestMapping
    public String getHomePage(Model model){
        model.addAttribute("wineries", wineryService.listAll());
        return "home";
    }

}
