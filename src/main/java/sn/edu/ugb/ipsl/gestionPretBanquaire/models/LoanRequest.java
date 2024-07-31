package sn.edu.ugb.ipsl.gestionPretBanquaire.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;

    @Column(nullable = false)
    private Double montantPret;

    @Column(nullable = false)
    private Integer dureePret;

    @Column(nullable = false)
    private String statusId;

    @Column(nullable = false)
    private java.sql.Timestamp dateSoumission;

}