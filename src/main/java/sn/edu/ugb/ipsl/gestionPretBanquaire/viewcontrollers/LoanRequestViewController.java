package sn.edu.ugb.ipsl.gestionPretBanquaire.viewcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Client;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.ClientService;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;

@Controller
public class LoanRequestViewController {

    @Autowired
    private LoanRequestService loanRequestService;

    @Autowired
    private ClientService clientService; // Service pour obtenir les détails du client

    @GetMapping("/demande-pret")
    public String showLoanRequestForm(Model model) {
        LoanRequest loanRequest = new LoanRequest();
        Client client = new Client(); // Initialisation du client
        model.addAttribute("loanRequest", loanRequest);
        model.addAttribute("client", client);
        return "loan-request";
    }

    @PostMapping("/demande-pret")
    public String submitLoanRequest(@ModelAttribute LoanRequest loanRequest, @ModelAttribute Client client,
            Model model) {
        // Vérifier que tous les champs nécessaires sont remplis
        if (client.getAge() == null || client.getIncome() == null) {
            model.addAttribute("error", "Veuillez remplir tous les champs requis.");
            return "loan-request";
        }

        // Sauvegarde des informations du client
        clientService.saveClient(client);

        // Associe le client à la demande de prêt
        loanRequest.setClient(client);

        // Enregistre la demande de prêt
        loanRequestService.saveLoanRequest(loanRequest);

        return "redirect:/success"; // Page de succès ou autre
    }
}
