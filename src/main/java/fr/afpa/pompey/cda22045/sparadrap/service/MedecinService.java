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

    public Medecin updateMedecin(Long id, Medecin updateMedecin) {
        if (medecinRepository.existsById(id)) {
            updateMedecin.setPer_id(id);
            return medecinRepository.save(updateMedecin);
        } else {
            // Gérer le cas où le medecin n'existe pas
            return null;
        }
    }

    public boolean deleteMedecin(Long id) {
        if (medecinRepository.existsById(id)) {
            medecinRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
