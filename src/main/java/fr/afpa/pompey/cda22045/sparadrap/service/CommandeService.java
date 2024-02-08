package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.Article;
import fr.afpa.pompey.cda22045.sparadrap.model.Commande;
import fr.afpa.pompey.cda22045.sparadrap.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public CommandeService(){}

    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    public Commande updateCommande(Long id, Commande updateCommande) {
        if (commandeRepository.existsById(id)) {
            updateCommande.setCom_id(id);
            return commandeRepository.save(updateCommande);
        } else {
            // Gérer le cas ou la commande n'existe pas
            return null;
        }
    }

    public boolean deleteCommande(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
