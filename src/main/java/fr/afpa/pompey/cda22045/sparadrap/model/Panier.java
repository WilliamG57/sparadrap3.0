package fr.afpa.pompey.cda22045.sparadrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Panier {

    private ArrayList<Commande> commandes = new ArrayList<>();

    private String nom;
    private String date;
    private Medecin medecin;
    private Specialiste specialiste;
    private Boolean ordonnance;

    public Panier(String nom, String date,Medecin medecin, Specialiste specialiste,  Boolean ordonnance) {
        this.nom = nom;
        this.date = date;
        this.medecin = medecin;
        this.specialiste = specialiste;
        this.ordonnance = ordonnance;
    }

    public Panier(String nom, String date) {
        this.nom = nom;
        this.date = date;
    }
}
