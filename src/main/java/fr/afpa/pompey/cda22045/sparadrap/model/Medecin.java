package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Medecin extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "med_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Personne personne;

    @Column(name = "med_agreement")
    private int numAgreement;
}
