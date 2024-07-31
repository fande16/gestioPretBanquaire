package sn.edu.ugb.ipsl.gestionPretBanquaire.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
