package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.CategorieMedi;
import fr.afpa.pompey.cda22045.sparadrap.service.CategorieMediService;
import fr.afpa.pompey.cda22045.sparadrap.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieMediController {

    @Autowired
    private CategorieMediService categorieMediService;

    @GetMapping
    public List<CategorieMedi> getAllCategorieMedi() {
        return categorieMediService.getAllCategorieMedi();
    }

    @PutMapping("/{id}")
    public CategorieMedi updateCategorieMedi(@PathVariable Long id, @RequestBody CategorieMedi updateCategorieMedi) {
        return categorieMediService.updateCategorieMedi(id, updateCategorieMedi);
    }

    @PostMapping
    public ResponseEntity<CategorieMedi> createCategorieMedi(@RequestBody CategorieMedi newCategorieMedi) throws MyException {
        CategorieMedi createCategorieMedi = categorieMediService.save(newCategorieMedi);
        return ResponseEntity.ok(createCategorieMedi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategorieMedi(@PathVariable Long id) {
        boolean isRemoved = categorieMediService.deleteCategorieMedi(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
