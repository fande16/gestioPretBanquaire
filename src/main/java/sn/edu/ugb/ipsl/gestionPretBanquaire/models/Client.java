package sn.edu.ugb.ipsl.gestionPretBanquaire.models;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;
    private String address;

    @Column(nullable = false)
    private Double income;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String employmentStatus;

    @Column(nullable = false)
    private Double otherDebts;

    @OneToMany(mappedBy = "client")
    private List<LoanRequest> loanRequests;


}