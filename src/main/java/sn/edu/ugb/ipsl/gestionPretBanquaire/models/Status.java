package sn.edu.ugb.ipsl.gestionPretBanquaire.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "statuses", uniqueConstraints = { @UniqueConstraint(columnNames = "status_name") })
@Data
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name", nullable = false, length = 50, unique = true)
    private String status_name;
}
