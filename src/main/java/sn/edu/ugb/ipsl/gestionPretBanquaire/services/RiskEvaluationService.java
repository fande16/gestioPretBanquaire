package sn.edu.ugb.ipsl.gestionPretBanquaire.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Client;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.RiskScore;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.LoanRequestRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.RiskScoreRepository;

import java.sql.Timestamp;


@Service
public class RiskEvaluationService {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    @Autowired
    private RiskScoreRepository riskScoreRepository;

    public double calculateRiskScore(Double income, Double creditHistoryScore, Integer loanDurationMonths, Integer age, String employmentStatus, Double otherDebts) {
        double score = 0.0;

        // Facteur de revenu
        if (income < 20000) {
            score += 30;
        } else if (income < 50000) {
            score += 20;
        } else {
            score += 10;
        }

        // Facteur d'historique de crédit
        score += (100 - creditHistoryScore);

        // Facteur de durée de prêt
        if (loanDurationMonths > 60) {
            score += 20;
        } else if (loanDurationMonths > 36) {
            score += 10;
        }

        // Facteur d'âge
        if (age < 25) {
            score += 10;
        } else if (age > 60) {
            score += 15;
        }

        // Facteur d'emploi
        if (employmentStatus.equals("Unemployed")) {
            score += 25;
        } else if (employmentStatus.equals("Self-Employed")) {
            score += 10;
        }

        // Facteur de dettes supplémentaires
        if (otherDebts > 0) {
            score += (otherDebts / income) * 100;
        }

        return score;
    }

    @Transactional
    public void evaluateAndStoreRiskScore(Long loanRequestId) {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        Client client = loanRequest.getClient();

        // Pour simplifier, nous utilisons une valeur fixe pour creditHistoryScore.
        // Idéalement, ce score devrait provenir d'une source externe ou d'une autre table.
        double creditHistoryScore = 75.0;

        double riskScore = calculateRiskScore(client.getIncome(), creditHistoryScore, loanRequest.getDureePret(),
                client.getAge(), client.getEmploymentStatus(), client.getOtherDebts());

        RiskScore riskScoreEntity = new RiskScore();
        riskScoreEntity.setLoanRequest(loanRequest);
        riskScoreEntity.setScore(riskScore);
        riskScoreEntity.setCreditHistoryScore(creditHistoryScore);
        riskScoreEntity.setLoanDurationMonths(loanRequest.getDureePret());
        riskScoreEntity.setEvaluationDate(new Timestamp(System.currentTimeMillis()));

        riskScoreRepository.save(riskScoreEntity);
    }
}
