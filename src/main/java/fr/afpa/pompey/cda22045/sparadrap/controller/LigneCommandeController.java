package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.LigneCommande;
import fr.afpa.pompey.cda22045.sparadrap.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignearticles")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping
    public List<LigneCommande> getAllLigneCommande() {
        return ligneCommandeService.getAllLigneCommande();
    }

    @PutMapping("/{id}")
    public LigneCommande updateLigneCommande(@PathVariable Long id, @RequestBody LigneCommande updateLigneCommande) {
        return ligneCommandeService.updateLigneCommande(id, updateLigneCommande);
    }

    @PostMapping
    public ResponseEntity<LigneCommande> createLigneCommande(@RequestBody LigneCommande newLigneCommande) {
        LigneCommande createLigneCommande = ligneCommandeService.save(newLigneCommande);
        return ResponseEntity.ok(createLigneCommande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLigneCommande(@PathVariable Long id) {
        boolean isRemoved = ligneCommandeService.deleteLigneCommande(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
