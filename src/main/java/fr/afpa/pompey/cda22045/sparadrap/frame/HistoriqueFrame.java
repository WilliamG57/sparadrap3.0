package fr.afpa.pompey.cda22045.sparadrap.frame;


import fr.afpa.pompey.cda22045.sparadrap.frame.AccueilFrame;
import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.service.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class HistoriqueFrame extends JFrame {
    private JPanel historiquePanel;
    private JTable table1;
    private JTextField textField;

    public HistoriqueFrame() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        tableHistorique();
        setTitle("Historique");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(historiquePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(40, 500, 150, 20);
        historiquePanel.add(btnRetour);
        btnRetour.setVisible(true);
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });
    }

    public void tableHistorique() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Client", "Date", "Médecin", "Médicament", "Spécialiste", "Ordonnance"}, 0);
        for (Historique historique : HistoriqueService.getHistorique()) {
            model.addRow(new Object[]{
                    historique.getNom(),
                    historique.getDate(),
                    historique.getMedecin(),
                    historique.getMedicament(),
                    historique.getSpecialiste(),
                    historique.getOrdonnance()
            });
        }
        table1 = new JTable(model);
        historiquePanel.add(new JScrollPane(table1));
        getContentPane().add(historiquePanel);
        table1.setDefaultEditor(Object.class, null);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 30));
        historiquePanel.add(textField);
        textField.setVisible(true);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String terme = textField.getText();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                sorter.setRowFilter(RowFilter.regexFilter(terme));
                table1.setRowSorter(sorter);
            }
        });
    }

}
