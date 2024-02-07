package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public MedicamentService() {
    }

    public Medicament save(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    public Optional<Medicament> getClientById(Long id) {
        return medicamentRepository.findById(id);
    }

    public List<Medicament> getAllMedicament() {
        return medicamentRepository.findAll();
    }

    public Medicament updateMedicament(Long id, Medicament updateMedicament) {
        if (medicamentRepository.existsById(id)) {
            updateMedicament.setMedi_id(id);
            return medicamentRepository.save(updateMedicament);
        } else {
            // Gérer le cas où le medicament n'existe pas
            return null;
        }
    }

    public boolean deleteMedicament(Long id) {
        if (medicamentRepository.existsById(id)) {
            medicamentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
