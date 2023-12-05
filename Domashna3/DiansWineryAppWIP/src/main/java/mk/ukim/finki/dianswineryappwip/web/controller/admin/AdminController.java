package mk.ukim.finki.dianswineryappwip.web.controller.admin;

import mk.ukim.finki.dianswineryappwip.service.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final WineryService wineryService;

    public AdminController(WineryService wineryService) {
        this.wineryService = wineryService;
    }

    @GetMapping
    public String getAdminDashboard(Model model) {
        model.addAttribute("pageTitle", "Admin Dashboard - WineMapper");
        model.addAttribute("mainBodyContent", "admin/admin-dashboard");

        return "master-template";
    }

    @PostMapping("/update-wineries-in-database")
    public String updateFacilitiesInDatabase(Model model) {
        wineryService.populateDatabaseFromCSV();
        model.addAttribute("mainBodyContent", "admin/admin-dashboard");
        model.addAttribute("wineries", wineryService.listAll());
        return "master-template";
    }



}
