package fr.afpa.pompey.cda22045.sparadrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneArticle {

    private Medicament medicament;
    private double prix;
    private int quantite;

}
