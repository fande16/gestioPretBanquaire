package sn.edu.ugb.ipsl.gestionPretBanquaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Contract;
import sn.edu.ugb.ipsl.gestionPretBanquaire.services.ContractService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract savedContract = contractService.saveContract(contract);
        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.getAllContracts();
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.getContractById(id);
        return contract.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        if (!contractService.getContractById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contract.setId(id);
        Contract updatedContract = contractService.saveContract(contract);
        return ResponseEntity.ok(updatedContract);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        if (!contractService.getContractById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
