package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Medecin extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long med_id;

    @OneToOne
    @JoinColumn(name = "per_id", referencedColumnName = "id")
    private Personne personne;

    @Column(name = "med_agreement")
    private int numAgreement;
}
