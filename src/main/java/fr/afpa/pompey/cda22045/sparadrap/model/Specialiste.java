package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Specialiste extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String specialite;
}
