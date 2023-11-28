package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;

import java.util.ArrayList;

public class HistoriqueService {

    /**
     * Declaration de la liste contenant les historiques
     */
    private static final ArrayList<Historique> historique = new ArrayList<>();

    public static ArrayList<Historique> getHistorique() {
        return historique;
    }

    public HistoriqueService() {
    }

    /**
     * Methode pour transferer le panier dans l'historique
     */
    public Historique transfertPanierHistorique(Panier p) {
        Historique h = new Historique();
        h.setNom(p.getNom());
        h.setMedecin(p.getMedecin());
        try {
            DateManagment.parse(p.getDate(), "La date n'est pas au bon format");
            h.setDate(p.getDate());
        } catch (MyException ex) {
            throw new RuntimeException(ex);
        }
        h.setSpecialiste(p.getSpecialiste());
        h.setOrdonnance(p.getOrdonnance());
        for (LigneArticle la : p.getLigneArticles()) {
            h.setMedicament(la.getMedicament());
            h.setPrix(la.getPrix());
            h.setQuantite(la.getQuantite());
        }
        return h;
    }

    public void ajoutHistorique(Historique h) throws MyException {
        historique.add(h);
    }
}
