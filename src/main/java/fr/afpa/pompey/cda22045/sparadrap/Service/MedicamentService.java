package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;

import java.util.List;

public class MedicamentService {

    private MedicamentDAO medicamentDAO = new MedicamentDAO();
    private CategorieMediDAO categorieMediDAO = new CategorieMediDAO();

    public List<Medicament> findAll() {
        try {
            List<Medicament> medicaments = medicamentDAO.findAll();
            for (Medicament medi : medicaments) {
                CategorieMedi cm = categorieMediDAO.find(medi.getCategorie_id());
                if (cm != null) {
                    medi.setCategorieMedi(cm);
                }
            }
            return medicaments;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
