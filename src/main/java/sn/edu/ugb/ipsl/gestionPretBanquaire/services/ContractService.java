package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Contract;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    public Optional<Contract> getContractById(Long id) {
        return contractRepository.findById(id);
    }

    public void deleteContract(Long id) {
        contractRepository.deleteById(id);
    }
}
