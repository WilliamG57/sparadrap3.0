package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Mutuelle;
import fr.afpa.pompey.cda22045.sparadrap.service.MutuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutuelles")
public class MutuelleController {

    @Autowired
    private MutuelleService mutuelleService;

    @GetMapping
    public List<Mutuelle> getAllMutuelle() {
        return mutuelleService.getAllMutuelle();
    }

    @PutMapping("/{id}")
    public Mutuelle updateMutuelle(@PathVariable Long id, @RequestBody Mutuelle updateMutuelle) {
        return mutuelleService.updateMutuelle(id, updateMutuelle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMutuelle(@PathVariable Long id) {
        boolean isRemoved = mutuelleService.deleteMutuelle(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
