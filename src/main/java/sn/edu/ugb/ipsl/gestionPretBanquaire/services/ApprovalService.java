package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Approval;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.ApprovalRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.LoanRequestRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Autowired
    private LoanRequestRepository loanRequestRepository;

    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    public Optional<Approval> getApprovalById(Long id) {
        return approvalRepository.findById(id);
    }

    @Transactional
    public Approval createApproval(Long loanRequestId, String approvalStatus) {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        Approval approval = new Approval();
        approval.setLoanRequest(loanRequest);
        approval.setApprovalStatus(approvalStatus);
        approval.setDecisionDate(new Timestamp(System.currentTimeMillis()));

        return approvalRepository.save(approval);
    }

    @Transactional
    public Approval updateApproval(Long id, String approvalStatus) {
        Approval approval = approvalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));

        approval.setApprovalStatus(approvalStatus);
        approval.setDecisionDate(new Timestamp(System.currentTimeMillis()));

        return approvalRepository.save(approval);
    }

    public void deleteApproval(Long id) {
        approvalRepository.deleteById(id);
    }
}
