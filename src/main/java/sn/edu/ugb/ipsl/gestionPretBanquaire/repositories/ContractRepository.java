package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici
}
