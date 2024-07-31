package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
