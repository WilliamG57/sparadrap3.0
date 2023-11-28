package fr.afpa.pompey.cda22045.sparadrap.frame;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.service.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;
import service.HistoriqueService;
import utils.MyException;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanierFrame extends JFrame {

    private JPanel panierPanel;
    private JTable tablePanier;
    private DefaultTableModel model;
    private Panier currentPanier;
    private HistoriqueService historiqueService = new HistoriqueService();

    public PanierFrame(Panier pa) throws MyException {
        currentPanier = pa;
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        tablePanier();
        setTitle("Panier");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panierPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnValider = new JButton("Valider");
        btnValider.setBounds(80, 500, 150, 20);
        panierPanel.add(btnValider);
        btnValider.setVisible(true);
        JButton btnSupprimer = new JButton("Supprimer");
        btnValider.setBounds(80, 500, 150, 20);
        panierPanel.add(btnSupprimer);
        btnSupprimer.setVisible(true);
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(40, 500, 150, 20);
        panierPanel.add(btnRetour);
        btnRetour.setVisible(true);

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Historique h = historiqueService.transfertPanierHistorique(currentPanier);
                try {
                    historiqueService.ajoutHistorique(h);
                    pa.getLigneArticles().clear();
                } catch (MyException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Achat validée");
                dispose();
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablePanier.getSelectedRow() != -1) {
                    int ligneSelection = tablePanier.getSelectedRow();
                    pa.getLigneArticles().remove(ligneSelection);
                    model.removeRow(ligneSelection);
                }
            }
        });
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void tablePanier() {
        model = new DefaultTableModel(new String[]{"Médicament", "Quantité", "Prix/u"}, 0);
        for (LigneArticle ligneArticles : currentPanier.getLigneArticles()) {
            model.addRow(new Object[]{
                    ligneArticles.getMedicament(),
                    ligneArticles.getQuantite(),
                    ligneArticles.getPrix()
            });
        }
        tablePanier = new JTable(model);
        panierPanel.add(new JScrollPane(tablePanier));
        getContentPane().add(panierPanel);
        tablePanier.setDefaultEditor(Object.class, null);
    }
}

