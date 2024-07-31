package sn.edu.ugb.ipsl.gestionPretBanquaire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.PaymentSchedule;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {
}