package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Medecin extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long med_id;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Personne personne;

    @Column(name = "med_agreement")
    private int numAgreement;

}
