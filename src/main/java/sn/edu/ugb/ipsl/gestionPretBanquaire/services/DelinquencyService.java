package sn.edu.ugb.ipsl.gestionPretBanquaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.gestionPretBanquaire.models.Delinquency;
import sn.edu.ugb.ipsl.gestionPretBanquaire.repositories.DelinquencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DelinquencyService {

    @Autowired
    private DelinquencyRepository delinquencyRepository;

    public List<Delinquency> getAllDelinquencies() {
        return delinquencyRepository.findAll();
    }

    public Optional<Delinquency> getDelinquencyById(Long id) {
        return delinquencyRepository.findById(id);
    }

    public Delinquency saveDelinquency(Delinquency delinquency) {
        return delinquencyRepository.save(delinquency);
    }

    public void deleteDelinquency(Long id) {
        delinquencyRepository.deleteById(id);
    }
}
