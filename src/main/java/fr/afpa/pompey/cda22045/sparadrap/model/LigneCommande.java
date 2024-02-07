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
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ligne_id;

    @ManyToOne
    @JoinColumn(name = "com_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Article article;
}
