package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Delinquency;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.DelinquencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/delinquencies")
public class DelinquencyController {

    @Autowired
    private DelinquencyService delinquencyService;

    @GetMapping
    public ResponseEntity<List<Delinquency>> getAllDelinquencies() {
        List<Delinquency> delinquencies = delinquencyService.getAllDelinquencies();
        return ResponseEntity.ok(delinquencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delinquency> getDelinquencyById(@PathVariable Long id) {
        Optional<Delinquency> delinquency = delinquencyService.getDelinquencyById(id);
        return delinquency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Delinquency> createDelinquency(@RequestBody Delinquency delinquency) {
        Delinquency savedDelinquency = delinquencyService.saveDelinquency(delinquency);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDelinquency);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delinquency> updateDelinquency(@PathVariable Long id, @RequestBody Delinquency delinquency) {
        if (delinquencyService.getDelinquencyById(id).isPresent()) {
            delinquency.setId(id);
            Delinquency updatedDelinquency = delinquencyService.saveDelinquency(delinquency);
            return ResponseEntity.ok(updatedDelinquency);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelinquency(@PathVariable Long id) {
        if (delinquencyService.getDelinquencyById(id).isPresent()) {
            delinquencyService.deleteDelinquency(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
