package fr.afpa.pompey.cda22045.sparadrap.service;

import fr.afpa.pompey.cda22045.sparadrap.model.CategorieMedi;
import fr.afpa.pompey.cda22045.sparadrap.repository.CategorieMediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieMediService {

    @Autowired
    private CategorieMediRepository categorieMediRepository;

    public CategorieMedi save(CategorieMedi categorieMedi) {
        return categorieMediRepository.save(categorieMedi);
    }

    public Optional<CategorieMedi> getCategorieMediById(Long id) {
        return categorieMediRepository.findById(id);
    }

    public List<CategorieMedi> getAllCategorieMedi() {
        return categorieMediRepository.findAll();
    }

    public CategorieMedi updateCategorieMedi(Long id, CategorieMedi updateCategorieMedi) {
        if (categorieMediRepository.existsById(id)) {
            updateCategorieMedi.setCat_id(id);
            return categorieMediRepository.save(updateCategorieMedi);
        } else {
            // Gérer le cas où la mutuelle n'existe pas
            return null;
        }
    }

    public boolean deleteCategorieMedi(Long id) {
        if (categorieMediRepository.existsById(id)) {
            categorieMediRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
