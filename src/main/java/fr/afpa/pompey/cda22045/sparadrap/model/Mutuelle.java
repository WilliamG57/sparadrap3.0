package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Mutuelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mut_id;

    private String nom;
}
