package fr.afpa.pompey.cda22045.sparadrap.frame;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.service.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateClientFrame extends JFrame {
    private JPanel createPanel;
    private JButton btnRetour;
    private JTextField textNom;
    private JTextField textMail;
    private JTextField textAdresse;
    private JTextField textPrenom;
    private JTextField textTelephone;
    private JTextField textPostal;
    private JTextField textNaissance;
    private JButton btnCreate;
    private JTextField textSecu;
    private JTextField textVille;
    private JComboBox comboSpecialiste;
    private JComboBox comboMedecin;
    private JComboBox comboMutuelle;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JLabel dateClient;
    private JLabel mailClient;
    private JLabel telClient;
    private JLabel secuClient;
    private JLabel adresseClient;
    private JLabel postalClient;
    private JLabel villeClient;
    private JLabel mutuelleClient;
    private JLabel medecinClient;
    private JLabel specialisteClient;

    private ClientService clientService = new ClientService();
    private MedecinService medecinService = new MedecinService();
    private SpecialisteService specialisteService = new SpecialisteService();
    private MutuelleService mutuelleService = new MutuelleService();
//    private ClientDAO clientDAO = new ClientDAO();
//    private MedecinDAO medecinDAO = new MedecinDAO();
//    private SpecialisteDAO specialisteDAO = new SpecialisteDAO();
//    private MutuelleDAO mutuelleDAO = new MutuelleDAO();

    public CreateClientFrame() throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(createPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Medecin medecins : medecinService.getAllMedecin()) {
            comboMedecin.addItem(medecins);
            comboMedecin.setSelectedIndex(-1);
        }

        for (Specialiste specialistes : specialisteService.getAllSpecialiste()) {
            comboSpecialiste.addItem(specialistes);
            comboSpecialiste.setSelectedIndex(-1);
        }
        for (Mutuelle mutuelle : mutuelleService.getAllMutuelle()) {
            comboMutuelle.addItem(mutuelle);
            comboMutuelle.setSelectedIndex(-1);
        }
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccueilFrame.designAccueil();
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectItem = comboMutuelle.getSelectedItem();
                long muId = ((Mutuelle) selectItem).getMut_id();
                Object selectItem1 = comboMedecin.getSelectedItem();
                long mId = ((Medecin) selectItem1).getPer_id();
                Object selectItem2 = comboSpecialiste.getSelectedItem();
                long sId = ((Specialiste) selectItem2).getPer_id();
                try {
                    Client cl = getClients(muId, mId, sId);
                    clientService.save(cl);
                    JOptionPane.showMessageDialog(null, "Nouveau client ajouté !");
                    dispose();
                    AccueilFrame.designAccueil();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private Client getClients(long muId, long mId, long sId) {

        String nom = textNom.getText();
        String prenom = textPrenom.getText();
        String adresse = textAdresse.getText();
        String codePostal = textPostal.getText();
        String ville = textVille.getText();
        String telephone = textTelephone.getText();
        String email = textMail.getText();
        String securiteSocial = textSecu.getText();
        String dateNaissance = textNaissance.getText();
        long mutuelle = muId;
        long medecin = mId;
        long specialiste = sId;
        Client cl =
                new Client(nom, prenom, adresse, codePostal, ville, telephone, email,
                        securiteSocial, dateNaissance, mutuelle, medecin, specialiste);
        return cl;
    }
}
















