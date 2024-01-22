package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medi_id;

    @Column(name = "medi_nom")
    private String nom;

    @Column(name = "medi_prix")
    private double prix;

    @Column(name = "medi_stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategorieMedi categorieMedicament;
}
