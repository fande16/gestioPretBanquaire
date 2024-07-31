package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Approval;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.ApprovalService;

import java.util.List;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping
    public List<Approval> getAllApprovals() {
        return approvalService.getAllApprovals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Long id) {
        return approvalService.getApprovalById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Approval createApproval(@RequestParam Long loanRequestId, @RequestParam String approvalStatus) {
        return approvalService.createApproval(loanRequestId, approvalStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable Long id, @RequestParam String approvalStatus) {
        return ResponseEntity.ok(approvalService.updateApproval(id, approvalStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApproval(@PathVariable Long id) {
        approvalService.deleteApproval(id);
        return ResponseEntity.noContent().build();
    }
}
