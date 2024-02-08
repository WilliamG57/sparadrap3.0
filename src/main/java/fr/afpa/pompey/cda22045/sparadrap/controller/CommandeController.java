package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Commande;
import fr.afpa.pompey.cda22045.sparadrap.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommande() {
        return commandeService.getAllCommande();
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande updateCommande) {
        return commandeService.updateCommande(id, updateCommande);
    }

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande newCommande) {
        Commande createCommande = commandeService.save(newCommande);
        return ResponseEntity.ok(createCommande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        boolean isRemoved = commandeService.deleteCommande(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
