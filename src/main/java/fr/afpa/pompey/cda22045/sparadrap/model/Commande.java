package fr.afpa.pompey.cda22045.sparadrap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {

    private Medicament medicament;
    private int quantite;

    public Commande(Medicament medicament, double prix, int quantite) {
    }
}
