package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.PaymentSchedule;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.PaymentScheduleService;

import java.util.List;

@RestController
@RequestMapping("/paymentSchedules")
public class PaymentScheduleController {

    @Autowired
    private PaymentScheduleService paymentScheduleService;

    @GetMapping
    public List<PaymentSchedule> getAllPaymentSchedules() {
        return paymentScheduleService.getAllPaymentSchedules();
    }

    @GetMapping("/{id}")
    public PaymentSchedule getPaymentScheduleById(@PathVariable Long id) {
        return paymentScheduleService.getPaymentScheduleById(id);
    }

    @PostMapping
    public PaymentSchedule createPaymentSchedule(@RequestBody PaymentSchedule paymentSchedule) {
        return paymentScheduleService.savePaymentSchedule(paymentSchedule);
    }

    @PutMapping("/{id}")
    public PaymentSchedule updatePaymentSchedule(@PathVariable Long id, @RequestBody PaymentSchedule paymentScheduleDetails) {
        return paymentScheduleService.updatePaymentSchedule(id, paymentScheduleDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentScheduleById(@PathVariable Long id) {
        paymentScheduleService.deletePaymentScheduleById(id);
    }
}
