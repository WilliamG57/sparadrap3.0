package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Medicament")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medi_id;

    @Column(name = "medi_nom")
    private String nom;

    @Column(name = "medi_prix")
    private double prix;

    @Column(name = "medi_miseenservice")
    private String miseEnService;

    @Column(name = "medi_stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategorieMedi categorieMedicament;
}
