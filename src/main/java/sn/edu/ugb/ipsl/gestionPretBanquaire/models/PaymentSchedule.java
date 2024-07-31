package sn.edu.ugb.ipsl.gestionPretBanquaire.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_request_id", nullable = false)
    private LoanRequest loanRequest;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private java.sql.Timestamp dueDate;

    @Column(nullable = true)
    private Boolean paid;
}