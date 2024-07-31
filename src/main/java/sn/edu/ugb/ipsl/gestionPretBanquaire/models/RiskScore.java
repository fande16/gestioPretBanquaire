package sn.edu.ugb.ipsl.gestionPretBanquaire.models;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_request_id", nullable = false)
    private LoanRequest loanRequest;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Double creditHistoryScore;

    @Column(nullable = false)
    private Integer loanDurationMonths;

    @Column(nullable = false)
    private java.sql.Timestamp evaluationDate;

    // Getters and Setters
}