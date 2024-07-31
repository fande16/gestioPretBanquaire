package sn.edu.ugb.ipsl.gestionPretBanquaire.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_request_id", nullable = false)
    @JsonBackReference
    private LoanRequest loanRequest;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_path")
    private String documentPath;

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    
}
