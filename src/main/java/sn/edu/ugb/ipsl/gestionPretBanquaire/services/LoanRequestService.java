package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.LoanRequestRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRequestService {

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    public List<LoanRequest> getAllLoanRequests() {
        return loanRequestRepository.findAll();
    }

    public void saveLoanRequest(LoanRequest loanRequest) {
        loanRequestRepository.save(loanRequest);
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
}
