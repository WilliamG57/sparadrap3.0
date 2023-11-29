package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;
import fr.afpa.pompey.cda22045.sparadrap.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;
    private MedicamentDAO medicamentDAO = new MedicamentDAO();
    private CategorieMediDAO categorieMediDAO = new CategorieMediDAO();

    public MedicamentService() {

    }

    public List<Medicament> findAll() {
        try {
            List<Medicament> medicaments = medicamentDAO.findAll();
            for (Medicament medi : medicaments) {
                CategorieMedi cm = categorieMediDAO.find(medi.getCategorieMedicament().getCat_id());
                if (cm != null) {
                    medi.setCategorieMedicament(cm);
                }
            }
            return medicaments;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
