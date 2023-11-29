package fr.afpa.pompey.cda22045.sparadrap.frame;

import fr.afpa.pompey.cda22045.sparadrap.service.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;
import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AchatOrdonnanceFrame extends JFrame {
    private JTextField textPrix;
    private JTextField textQuantite;
    private JTextField textDate;
    private JComboBox comboMedecin;
    private JComboBox comboClient;
    private JLabel textTitre;
    private JLabel labelClient;
    private JLabel labelMedecin;
    private JLabel labelMedicament;
    private JComboBox comboMedicament;
    private JLabel labelDate;
    private JPanel OrdonnancePanel;
    private JLabel labelQuantite;
    private JLabel labelPrix;
    private JButton btnConfirmer;
    private JButton btnRetour;
    private JComboBox comboSpecialiste;
    private JLabel textSpecialiste;
    private JTextField textBoolean;
    private PanierService panierService = new PanierService();
    ClientService clientService = new ClientService();
    MedecinDAO medecinDAO = new MedecinDAO();
    SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    MutuelleDAO mutuelleDAO = new MutuelleDAO();
    MedicamentDAO medicamentDAO = new MedicamentDAO();



    public AchatOrdonnanceFrame() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Traitement Ordonnance");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(OrdonnancePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Client clients : clientService.findAll()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
        }

        for (Medecin medecins : medecinDAO.findAll()) {
            comboMedecin.addItem(medecins.getNom());
            comboMedecin.setSelectedIndex(-1);
        }

        for (Specialiste specialistes : specialisteDAO.findAll()) {
            comboSpecialiste.addItem(specialistes.getNom());
            comboSpecialiste.setSelectedIndex(-1);
        }

        for (Medicament medicaments : medicamentDAO.findAll()) {
            comboMedicament.addItem(medicaments.getNom());
            comboMedicament.setSelectedIndex(-1);
            comboMedicament.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (medicaments.getNom().equals(comboMedicament.getSelectedItem())) {
                        double prix = medicaments.getPrix();
                        textPrix.setText(String.valueOf(prix));
                    }
                }
            });
        }

        btnConfirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panierService.ajoutPanier((String) comboClient.getSelectedItem(), textDate.getText(), (Medecin) comboMedecin.getSelectedItem(),
                            (Specialiste) comboSpecialiste.getSelectedItem(), Boolean.valueOf(textBoolean.getText()));
                    panierService.ajoutLigneArticle((Medicament) comboMedicament.getSelectedItem(), Integer.parseInt(textQuantite.getText()), textPrix.getX());
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                try {
                    Ordonnance.ajoutOrdonnances((String) comboClient.getSelectedItem(), textDate.getText(), (String) comboMedicament.getSelectedItem(),
                            textQuantite.getText(), textPrix.getText(), (String) comboMedecin.getSelectedItem(), (String) comboSpecialiste.getSelectedItem());
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Enregistré dans le panier");
                PanierFrame y = null;
                try {
                    y = new PanierFrame(panierService.getPanier());
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });
    }
}
