package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.LoanRequestRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    public List<LoanRequest> getAllLoanRequests() {
        return loanRequestRepository.findAll();
    }

    public LoanRequest saveLoanRequest(LoanRequest loanRequest) {
        if (loanRequest.getDateSoumission() == null) {
            loanRequest.setDateSoumission(Timestamp.from(Instant.now()));
        }
        loanRequestRepository.save(loanRequest);
        return loanRequest;
    }

    public LoanRequest getLoanRequestById(long id) {
        Optional<LoanRequest> optional = loanRequestRepository.findById(id);
        LoanRequest loanRequest = null;
        if (optional.isPresent()) {
            loanRequest = optional.get();
        } else {
            throw new RuntimeException("Montant prêt non trouvé pour l'id :: " + id);
        }
        return loanRequest;
    }

    public void deleteLoanRequestById(long id) {
        loanRequestRepository.deleteById(id);
    }

    public LoanRequest updateLoanRequest(long id, LoanRequest loanRequestDetails) {
        LoanRequest loanRequest = loanRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LoanRequest non trouvé pour l'id :: " + id));

        loanRequest.setClient(loanRequestDetails.getClient());
        loanRequest.setMontantPret(loanRequestDetails.getMontantPret());
        loanRequest.setDureePret(loanRequestDetails.getDureePret());
        loanRequest.setStatusId(loanRequestDetails.getStatusId());
        loanRequest.setDateSoumission(loanRequestDetails.getDateSoumission());

        loanRequestRepository.save(loanRequest);
        return loanRequest;
    }
}
