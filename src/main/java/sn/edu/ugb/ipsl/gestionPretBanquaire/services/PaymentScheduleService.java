package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.PaymentSchedule;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.PaymentScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentScheduleService {

    @Autowired
    private PaymentScheduleRepository paymentScheduleRepository;

    public List<PaymentSchedule> getAllPaymentSchedules() {
        return paymentScheduleRepository.findAll();
    }

    public PaymentSchedule getPaymentScheduleById(Long id) {
        Optional<PaymentSchedule> optional = paymentScheduleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("PaymentSchedule not found for id :: " + id);
        }
    }

    public PaymentSchedule savePaymentSchedule(PaymentSchedule paymentSchedule) {
        return paymentScheduleRepository.save(paymentSchedule);
    }

    public PaymentSchedule updatePaymentSchedule(Long id, PaymentSchedule paymentScheduleDetails) {
        PaymentSchedule paymentSchedule = paymentScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PaymentSchedule not found for id :: " + id));

        paymentSchedule.setLoanRequest(paymentScheduleDetails.getLoanRequest());
        paymentSchedule.setAmount(paymentScheduleDetails.getAmount());
        paymentSchedule.setDueDate(paymentScheduleDetails.getDueDate());
        paymentSchedule.setPaid(paymentScheduleDetails.getPaid());

        return paymentScheduleRepository.save(paymentSchedule);
    }

    public void deletePaymentScheduleById(Long id) {
        paymentScheduleRepository.deleteById(id);
    }
}
