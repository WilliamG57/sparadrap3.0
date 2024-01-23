package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Medicament;
import fr.afpa.pompey.cda22045.sparadrap.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @GetMapping
    public List<Medicament> getAllMedicament() {
        return medicamentService.getAllMedicament();
    }

    @PutMapping("/{id}")
    public Medicament updateMedicament(@PathVariable Long id, @RequestBody Medicament updateMedicament) {
        return medicamentService.updateMedicament(id, updateMedicament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicament(@PathVariable Long id) {
        boolean isRemoved = medicamentService.deleteMedicament(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
