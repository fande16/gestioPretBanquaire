package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
}