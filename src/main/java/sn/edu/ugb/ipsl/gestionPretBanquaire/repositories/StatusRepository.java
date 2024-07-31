package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
