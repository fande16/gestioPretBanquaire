package sn.edu.ugb.ipsl.gestionPretBanquaire.viewcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;

import java.util.List;

@Controller
@RequestMapping("/demande-pret")
public class LoanRequestViewController {

    @Autowired
    private LoanRequestService loanRequestService;

    @GetMapping
    public String showLoanRequestForm(Model model) {
        model.addAttribute("loanRequest", new LoanRequest());
        return "loan-request"; // Nom du template Thymeleaf pour le formulaire
    }

    @PostMapping
    public String submitLoanRequest(@ModelAttribute LoanRequest loanRequest) {
        loanRequestService.saveLoanRequest(loanRequest);
        return "redirect:/demande-pret/confirmation"; // Redirection vers la page de confirmation
    }

    @GetMapping("/liste")
    public String listLoanRequests(Model model) {
        List<LoanRequest> loanRequests = loanRequestService.getAllLoanRequests();
        model.addAttribute("loanRequests", loanRequests);
        return "list-demande-pret"; // Nom du template Thymeleaf pour la liste
    }

    @GetMapping("/confirmation")
    public String showConfirmationPage() {
        return "confirmation"; // Nom du template Thymeleaf pour la confirmation
    }
    @PostMapping("/approuver/{id}")
    public String approuverLoanRequest(@PathVariable Long id) {
        LoanRequest loanRequest = loanRequestService.getLoanRequestById(id);
        if (loanRequest != null) {
            loanRequest.setStatusId("Approuved");
            loanRequestService.saveLoanRequest(loanRequest);
        }
        return "redirect:/demande-pret/liste";
    }

    @PostMapping("/rejeter/{id}")
    public String rejeterLoanRequest(@PathVariable Long id) {
        LoanRequest loanRequest = loanRequestService.getLoanRequestById(id);
        if (loanRequest != null) {
            loanRequest.setStatusId("Rejeted");
            loanRequestService.saveLoanRequest(loanRequest);
        }
        return "redirect:/demande-pret/liste";
    }
}
