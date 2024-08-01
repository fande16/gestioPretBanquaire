package sn.edu.ugb.ipsl.gestionPretBanquaire.viewcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("homeController", "Bienvenue sur mon site !");
        return "index";
    }
}
