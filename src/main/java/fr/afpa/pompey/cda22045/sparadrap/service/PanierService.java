package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;
import lombok.Getter;

@Getter
public class PanierService {

    Panier panier = new Panier();

    public PanierService() {
    }

    public void ajoutPanier(String nom, String date) throws MyException {
        validationDate(date);
        if (!panierDejaExistant()) {
            panier = new Panier(nom, date);
        }
    }

    public void ajoutPanier(String nom, String date, Medecin medecin, Specialiste specialiste, Boolean Ordonnance) throws MyException {
        validationDate(date);
        if (!panierDejaExistant()) {
            panier = new Panier(nom, date, medecin, specialiste, Ordonnance);
        }
    }

    private boolean panierDejaExistant() {
        if (panier == null) {
            return false;
        } else if (panier.getNom() == null || panier.getNom().isEmpty()) {
            return false;
        }
        return true;
    }

    public void ajoutLigneArticle(Medicament medicament, int quantite, double prix) throws MyException {
        panier.getCommandes().add(new Commande(medicament, prix, quantite));
    }

    public void supprimerPanier() {
        this.panier = null;
        System.gc();
    }

    private void validationQte(int quantite, String message) throws MyException {

    }

    private void validationDate(String date) throws MyException {
        DateManagment.parse(date, "La date n'est pas au bon format");
    }

}