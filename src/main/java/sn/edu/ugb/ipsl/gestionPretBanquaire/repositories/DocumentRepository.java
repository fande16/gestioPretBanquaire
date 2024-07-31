package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
