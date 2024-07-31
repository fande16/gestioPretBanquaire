package sn.edu.ugb.ipsl.gestionPretBanquaire.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_request_id", nullable = false)
    private LoanRequest loanRequest;

    @Lob
    @Column(nullable = false)
    private String contractContent;

    @Column(nullable = false)
    private java.sql.Timestamp generationDate;

    @Column(nullable = false)
    private Boolean signed;

    @Column(nullable = true)
    private java.sql.Timestamp signingDate;
}