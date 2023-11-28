package fr.afpa.pompey.cda22045.sparadrap.frame;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;
import fr.afpa.pompey.cda22045.sparadrap.service.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AchatsFrame extends JFrame {
    private JPanel achatPanel;
    private JComboBox comboClient;
    private JButton btnAchat;
    private JButton btnRetour;
    private JLabel textClient;
    private JLabel labelDate;
    private JTextField textQuantite;
    private JTextField textPrix;
    private JTextField textDate;
    private JComboBox comboMedicament;
    private JLabel labelQuantite;
    private JLabel labelPrix;
    private JLabel labelMedicament;
    private JLabel textTitre;
    private JTextField textBoolean;
    private ClientDAO clientDAO = new ClientDAO();
    private MedicamentDAO medicamentDAO = new MedicamentDAO();

    private PanierService panierService = new PanierService();


    public AchatsFrame() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Achat");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(achatPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Client clients : clientDAO.findAll()) {
            comboClient.addItem(clients.getNom());
            comboClient.setSelectedIndex(-1);
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
        btnAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panierService.ajoutPanier((String) comboClient.getSelectedItem(), textDate.getText());
                    panierService.ajoutLigneArticle((String) comboMedicament.getSelectedItem(), Integer.parseInt(textQuantite.getText()), textPrix.getText());
                    JOptionPane.showMessageDialog(null, "Achat réalisé");
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    throw new RuntimeException(ex);
                }
                PanierFrame y = null;
                try {
                    y = new PanierFrame(panierService.getPanier());
                } catch (MyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

