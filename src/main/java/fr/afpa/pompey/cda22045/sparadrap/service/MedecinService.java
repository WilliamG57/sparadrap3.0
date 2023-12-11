package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Medecin;
import fr.afpa.pompey.cda22045.sparadrap.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService extends PersonneService{

    @Autowired
    private MedecinRepository medecinRepository;

    public MedecinService(){

    }

    public Medecin save(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public Optional<Medecin> getClientById(Long id) {
        return medecinRepository.findById(id);
    }

    public List<Medecin> getAllMedecin() {
        return medecinRepository.findAll();
    }

    public Medecin updatedMedecin(Long id, Medecin updatedMedecin) {
        if (medecinRepository.existsById(id)) {
            updatedMedecin.setPer_id(id);
            return medecinRepository.save(updatedMedecin);
        } else {
            // Gérer le cas où le medecin n'existe pas
            return null;
        }
    }
}
