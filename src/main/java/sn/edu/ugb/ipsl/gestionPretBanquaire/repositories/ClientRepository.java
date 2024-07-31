package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}