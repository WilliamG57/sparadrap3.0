package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "categorie")
@AllArgsConstructor
@NoArgsConstructor
public class CategorieMedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cat_id;

    @Column(name = "cat_nom", columnDefinition = "VARCHAR(255)")
    private String nom;
}
