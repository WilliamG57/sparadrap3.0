package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;

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

    public void ajoutPanier(String nom, String date, String medecin, String specialiste, Boolean Ordonnance) throws MyException {
        validationDate(date);
        if (!panierDejaExistant()) {
            panier = new Panier(nom, date, medecin, specialiste, Ordonnance);
        }
    }

    public Panier getPanier() {
        return panier;
    }

    private boolean panierDejaExistant() {
        if (panier == null) {
            return false;
        } else if (panier.getNom() == null || panier.getNom().isEmpty()) {
            return false;
        }
        return true;
    }

    public void ajoutLigneArticle(String medicament, int quantite, String prix) throws MyException {
        panier.getLigneArticles().add(new LigneArticle(medicament, quantite, prix));
    }
    public void supprimerPanier() {
        this.panier=null;
        System.gc();
    }

    private void validationQte (int quantite, String message) throws MyException{

    }
    private void validationDate(String date) throws MyException {
        DateManagment.parse(date, "La date n'est pas au bon format");
    }

}