package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
