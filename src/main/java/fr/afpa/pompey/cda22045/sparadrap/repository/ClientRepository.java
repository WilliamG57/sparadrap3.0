package fr.afpa.pompey.cda22045.sparadrap.repository;

import fr.afpa.pompey.cda22045.sparadrap.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
