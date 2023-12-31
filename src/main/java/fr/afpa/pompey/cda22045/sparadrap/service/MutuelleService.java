package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Mutuelle;
import fr.afpa.pompey.cda22045.sparadrap.repository.MutuelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MutuelleService {

    @Autowired
    private MutuelleRepository mutuelleRepository;

    public MutuelleService (){}

    public Mutuelle save(Mutuelle mutuelle) {
        return mutuelleRepository.save(mutuelle);
    }

    public Optional<Mutuelle> getClientById(Long id) {
        return mutuelleRepository.findById(id);
    }

    public List<Mutuelle> getAllMutuelle() {
        return mutuelleRepository.findAll();
    }

    public Mutuelle updatedMutuelle(Long id, Mutuelle updatedMutuelle) {
        if (mutuelleRepository.existsById(id)) {
            updatedMutuelle.setMut_id(id);
            return mutuelleRepository.save(updatedMutuelle);
        } else {
            // Gérer le cas où la mutuelle n'existe pas
            return null;
        }
    }
}
