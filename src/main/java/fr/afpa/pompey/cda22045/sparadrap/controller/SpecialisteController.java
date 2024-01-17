package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Specialiste;
import fr.afpa.pompey.cda22045.sparadrap.service.SpecialisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialistes")
public class SpecialisteController {

    @Autowired
    private SpecialisteService specialisteService;

    @GetMapping
    public List<Specialiste> getAllSpecialiste() {
        return specialisteService.getAllSpecialiste();
    }

    @PutMapping("/{id}")
    public Specialiste updateSpecialiste(@PathVariable Long id, @RequestBody Specialiste updateSpecialiste) {
        return specialisteService.updateSpecialiste(id, updateSpecialiste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialiste(@PathVariable Long id) {
        boolean isRemoved = specialisteService.deleteSpecialiste(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
