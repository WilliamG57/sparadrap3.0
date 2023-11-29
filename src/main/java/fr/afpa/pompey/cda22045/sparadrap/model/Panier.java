package fr.afpa.pompey.cda22045.sparadrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panier {

    private ArrayList<LigneArticle> ligneArticles = new ArrayList<>();

    private Medecin medecin;
    private Specialiste specialiste;
    private String nom;
    private String date;
    private Boolean ordonnance;

    public Panier(String nom, String date) {
    }

    public Panier(String nom, String date, Medecin medecin, Specialiste specialiste, Boolean ordonnance) {
    }
}
