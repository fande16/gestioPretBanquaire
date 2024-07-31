package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.LoanRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/loanRequests")
public class LoanRequestController {

    @Autowired
    private LoanRequestService loanRequestService;

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
        loanRequestService.saveLoanRequest(loanRequest);
        return loanRequest;
    }

    @PutMapping("/{id}")
    public LoanRequest updateLoanRequest(@PathVariable long id, @RequestBody LoanRequest loanRequestDetails) {
        return loanRequestService.updateLoanRequest(id, loanRequestDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLoanRequestById(@PathVariable long id) {
        loanRequestService.deleteLoanRequestById(id);
    }
}
