package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.RiskEvaluationService;

import java.util.List;

@RestController
@RequestMapping("/api/loanRequests")
public class LoanRequestController {

    @Autowired
    private LoanRequestService loanRequestService;

    @Autowired
    private RiskEvaluationService riskEvaluationService;

    @GetMapping
    public List<LoanRequest> getAllLoanRequests() {
        return loanRequestService.getAllLoanRequests();
    }

    @GetMapping("/{id}")
    public LoanRequest getLoanRequestById(@PathVariable long id) {
        return loanRequestService.getLoanRequestById(id);
    }

    @PostMapping
    public LoanRequest createLoanRequest(@RequestBody LoanRequest loanRequest) {
        LoanRequest savedLoanRequest = loanRequestService.saveLoanRequest(loanRequest);
        riskEvaluationService.evaluateAndStoreRiskScore(savedLoanRequest.getId());
        return savedLoanRequest;
    }

    @PutMapping("/{id}")
    public LoanRequest updateLoanRequest(@PathVariable long id, @RequestBody LoanRequest loanRequestDetails) {
        LoanRequest updatedLoanRequest = loanRequestService.updateLoanRequest(id, loanRequestDetails);
        // Évaluation et stockage du score de risque après la mise à jour
        riskEvaluationService.evaluateAndStoreRiskScore(updatedLoanRequest.getId());
        return updatedLoanRequest;
    }

    @DeleteMapping("/{id}")
    public void deleteLoanRequestById(@PathVariable long id) {
        loanRequestService.deleteLoanRequestById(id);
    }
}
