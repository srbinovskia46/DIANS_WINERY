package mk.ukim.finki.dianswineryappwip.web.controller.lang_mk;

import mk.ukim.finki.dianswineryappwip.model.Winery;
import mk.ukim.finki.dianswineryappwip.service.ReviewService;
import mk.ukim.finki.dianswineryappwip.service.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WineryMkController {

    private final WineryService wineryService;

    public WineryMkController(WineryService wineryService) {
        this.wineryService = wineryService;
    }
    @GetMapping("/wine-mapper_mkd")
    public String wineryMk(Model model) {
        List<Winery> wineries = wineryService.listAll();
        model.addAttribute("wineries", wineries);
        return "lang_mk/wine-mapper_mkd";
    }
}