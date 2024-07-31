package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Status;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.StatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
        Optional<Status> status = statusService.findById(id);
        return status.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) {
        return statusService.save(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
