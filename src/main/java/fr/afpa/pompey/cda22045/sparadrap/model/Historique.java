package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Historique {

    private Medecin medecin;
    private Medicament medicament;
    private Specialiste specialiste;
    private String nom;
    private String date;
    private int quantite;
    private double prix;
    private Boolean Ordonnance;


}
