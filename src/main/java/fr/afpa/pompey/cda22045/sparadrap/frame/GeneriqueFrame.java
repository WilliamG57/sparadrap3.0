package fr.afpa.pompey.cda22045.sparadrap.frame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;

public class GeneriqueFrame extends JFrame {
    private JPanel generiquePanel;
    private JTextField textNom;
    private JTextField textAdresse;
    private JTextField textTelephone;
    private JTextField textPrenom;
    private JTextField textPostal;
    private JTextField textEmail;
    private JTextField textVille;
    private JTextField textAgrement;
    private JLabel labelMedecin;
    private JLabel Agreement;
    private JLabel Email;
    private JLabel Telephone;
    private JLabel Adresse;
    private JLabel Nom;
    private JLabel Prenom;
    private JLabel Postal;
    private JLabel Ville;
    private MedecinDAO medecinDAO = new MedecinDAO();
    private SpecialisteDAO specialisteDAO = new SpecialisteDAO();


    public GeneriqueFrame(String nom, String type) throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Info");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(generiquePanel);
        if (type.equals("Medecin")) pourMedecin(nom);
        if (type.equals("Specialiste")) pourSpecialiste(nom);
    }

    public void pourMedecin(String nomMedecin) throws Exception {
        textNom.setText(nomMedecin);
        for (Medecin medecins : medecinDAO.findAll()) {
            if (medecins.getNom().equals(textNom.getText())) {
                textPrenom.setText(medecins.getPrenom());
                textAdresse.setText(medecins.getAdresse());
                textPostal.setText(medecins.getCodePostal());
                textVille.setText(medecins.getVille());
                textTelephone.setText(medecins.getTelephone());
                textEmail.setText(medecins.getEmail());
                textAgrement.setText(medecins.getNumAgreement() + "");
            }
        }
    }

    public void pourSpecialiste(String nomSpecialiste) throws Exception {
        textNom.setText(nomSpecialiste);
        for (Specialiste specialiste : specialisteDAO.findAll()) {
            if (specialiste.getNom().equals(textNom.getText())) {
                labelMedecin.setText("Spécialiste");
                Agreement.setText("Spécialité");
                textPrenom.setText(specialiste.getPrenom());
                textAdresse.setText(specialiste.getAdresse());
                textPostal.setText(specialiste.getCodePostal());
                textVille.setText(specialiste.getVille());
                textTelephone.setText(specialiste.getTelephone());
                textEmail.setText(specialiste.getEmail());
                textAgrement.setText(specialiste.getSpecialite());
            }
        }
    }
}
