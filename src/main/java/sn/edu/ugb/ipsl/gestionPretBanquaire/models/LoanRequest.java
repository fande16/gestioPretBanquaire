package sn.edu.ugb.ipsl.gestionPretBanquaire.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private Double montantPret;

    @Column(nullable = false)
    private Integer dureePret;

    @Column(nullable = false)
    private String statusId;

    @Column(nullable = false)
    private java.sql.Timestamp dateSoumission;

}}