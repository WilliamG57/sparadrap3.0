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

    public Medicament updatedMedicament(Long id, Medicament updatedMedicament) {
        if (medicamentRepository.existsById(id)) {
            updatedMedicament.setMedi_id(id);
            return medicamentRepository.save(updatedMedicament);
        } else {
            // Gérer le cas où le medicament n'existe pas
            return null;
        }
    }



//    public List<Medicament> findAll() {
//        try {
//            List<Medicament> medicaments = medicamentDAO.findAll();
//            for (Medicament medi : medicaments) {
//                CategorieMedi cm = categorieMediDAO.find(medi.getCategorieMedicament().getCat_id());
//                if (cm != null) {
//                    medi.setCategorieMedicament(cm);
//                }
//            }
//            return medicaments;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
