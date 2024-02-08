package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Commande;
import fr.afpa.pompey.cda22045.sparadrap.model.LigneCommande;
import fr.afpa.pompey.cda22045.sparadrap.repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService (){};

    public LigneCommande save(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    public Optional<LigneCommande> getLigneCommandeById(Long id) {
        return ligneCommandeRepository.findById(id);
    }

    public List<LigneCommande> getAllLigneCommande() {
        return ligneCommandeRepository.findAll();
    }

    public LigneCommande updateLigneCommande(Long id, LigneCommande updateLigneCommande) {
        if (ligneCommandeRepository.existsById(id)) {
            updateLigneCommande.setLigne_id(id);
            return ligneCommandeRepository.save(updateLigneCommande);
        } else {
            // Gérer le cas ou la ligne de commande n'existe pas
            return null;
        }
    }

    public boolean deleteLigneCommande(Long id) {
        if (ligneCommandeRepository.existsById(id)) {
            ligneCommandeRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
