package sn.edu.ugb.ipsl.gestionPretBanquaire.viewcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Payment;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.PaymentService;

@Controller
public class PaymentViewController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private LoanRequestService loanRequestService;

    @GetMapping("/payments")
    public String showPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payments";
    }

    @GetMapping("/payments/new")
    public String showPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        model.addAttribute("loanRequests", loanRequestService.getAllLoanRequests());
        return "payment-form";
    }

    @PostMapping("/payments")
    public String submitPayment(@ModelAttribute Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }
}
