package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Delinquency;

@Repository
public interface DelinquencyRepository extends JpaRepository<Delinquency, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
