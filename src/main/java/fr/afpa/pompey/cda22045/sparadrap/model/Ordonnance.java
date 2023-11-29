package fr.afpa.pompey.cda22045.sparadrap.model;

import fr.afpa.pompey.cda22045.sparadrap.utils.MyException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordonnance {

    private static final ArrayList<Ordonnance> Ordonnance = new ArrayList<>();

    private String nom;
    private String medecin;
    private String date;
    private String medicament;
    private String quantite;
    private String prix;
    private String specialiste;

    public static void ajoutOrdonnances(String nom, String date, String medicament, String quantite, String prix,
                                        String medecin, String specialiste) throws MyException {
        Ordonnance.add(new Ordonnance(nom, date, medicament, quantite, prix, medecin, specialiste));
    }
}
