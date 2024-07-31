package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.RiskScore;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
}
