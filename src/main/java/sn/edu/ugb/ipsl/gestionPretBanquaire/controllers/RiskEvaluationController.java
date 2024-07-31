package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.RiskEvaluationService;

@RestController
@RequestMapping("/api/risk")
public class RiskEvaluationController {

    @Autowired
    private RiskEvaluationService riskEvaluationService;

    @PostMapping("/evaluate/{loanRequestId}")
    public void evaluateRisk(@PathVariable Long loanRequestId) {
        riskEvaluationService.evaluateAndStoreRiskScore(loanRequestId);
    }
}
