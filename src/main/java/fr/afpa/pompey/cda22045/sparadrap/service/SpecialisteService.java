package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Specialiste;
import fr.afpa.pompey.cda22045.sparadrap.repository.SpecialisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialisteService {

    @Autowired
    private SpecialisteRepository specialisteRepository;

    public SpecialisteService() {
    }

    public Specialiste save(Specialiste specialiste) {
        return specialisteRepository.save(specialiste);
    }

    public Optional<Specialiste> getClientById(Long id) {
        return specialisteRepository.findById(id);
    }

    public List<Specialiste> getAllSpecialiste() {
        return specialisteRepository.findAll();
    }

    public Specialiste updateSpecialiste(Long id, Specialiste updateSpecialiste) {
        if (specialisteRepository.existsById(id)) {
            updateSpecialiste.setPer_id(id);
            return specialisteRepository.save(updateSpecialiste);
        } else {
            // Gérer le cas où le specialiste n'existe pas
            return null;
        }
    }

    public boolean deleteSpecialiste(Long id) {
        if (specialisteRepository.existsById(id)) {
            specialisteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
