package fr.afpa.pompey.cda22045.sparadrap.repository;

import fr.afpa.pompey.cda22045.sparadrap.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
