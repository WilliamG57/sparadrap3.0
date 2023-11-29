package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "categorie")
public class CategorieMedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cat_id;

    @Column(name = "cat_nom", columnDefinition = "VARCHAR(255)")
    private String categorie;
}
