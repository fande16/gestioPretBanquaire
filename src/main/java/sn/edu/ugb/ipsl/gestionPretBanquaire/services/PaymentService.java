package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.LoanRequest;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Payment;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.LoanRequestRepository;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.PaymentRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private LoanRequestRepository loanRequestRepository;


    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Transactional
    public Payment createPayment(Long loanRequestId, Double amount) {
        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        Payment payment = new Payment();
        payment.setLoanRequest(loanRequest);
        payment.setAmount(amount);
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment updatePayment(Long id, Double amount) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setAmount(amount);
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }


}
