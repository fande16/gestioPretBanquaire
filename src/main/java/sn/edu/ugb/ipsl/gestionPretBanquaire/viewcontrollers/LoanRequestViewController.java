package sn.edu.ugb.ipsl.gestionPretBanquaire.viewcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;

@Controller
public class LoanRequestViewController {

    @Autowired
    private LoanRequestService loanRequestService;

    @GetMapping("/demande-pret")
    public String showLoanRequestForm(Model model) {
        model.addAttribute("loanRequest", new LoanRequest());
        return "loan-request"; // Le nom du template Thymeleaf
    }

    @PostMapping("/demande-pret")
    public String submitLoanRequest(@ModelAttribute LoanRequest loanRequest) {
        loanRequestService.saveLoanRequest(loanRequest);
        return "redirect:/confirmation"; // Rediriger vers une page de confirmation ou autre
    }
}
