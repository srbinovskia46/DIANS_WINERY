package mk.ukim.finki.dianswineryappwip.web.controller;

import mk.ukim.finki.dianswineryappwip.model.Winery;
import mk.ukim.finki.dianswineryappwip.service.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping( "/wineries")
public class WineryController {

    private final WineryService wineryService;

    @Autowired
    public WineryController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @GetMapping
    public String showAllWineries(Model model) {
        List<Winery> wineries = wineryService.listAll();
        model.addAttribute("wineries", wineries);
        return "wine-mapper";
    }
}