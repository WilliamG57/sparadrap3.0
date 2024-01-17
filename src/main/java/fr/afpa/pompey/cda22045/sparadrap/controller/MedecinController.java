package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Medecin;
import fr.afpa.pompey.cda22045.sparadrap.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping
    public List<Medecin> getAllMedecin() {
        return medecinService.getAllMedecin();
    }

    @PutMapping("/{id}")
    public Medecin updateMedecin(@PathVariable Long id, @RequestBody Medecin updateMedecin) {
        return medecinService.updateMedecin(id, updateMedecin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedecin(@PathVariable Long id) {
        boolean isRemoved = medecinService.deleteMedecin(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
