package mk.ukim.finki.dianswineryappwip.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        // Remove geolocation data
        request.getSession().removeAttribute("userLatitude");
        request.getSession().removeAttribute("userLongitude");
        return "redirect:/login";
    }
}
