package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Historique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long his_id;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Medicament medicament;

    @ManyToOne
    private Specialiste specialiste;

    @Column
    private String nom;

    @Column
    private String date;

    @Column
    private int quantite;

    @Column
    private double prix;

    @Column
    private Boolean Ordonnance;
}
