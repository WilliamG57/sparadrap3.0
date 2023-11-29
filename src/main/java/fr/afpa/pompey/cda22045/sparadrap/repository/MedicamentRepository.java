package fr.afpa.pompey.cda22045.sparadrap.repository;

import fr.afpa.pompey.cda22045.sparadrap.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}
