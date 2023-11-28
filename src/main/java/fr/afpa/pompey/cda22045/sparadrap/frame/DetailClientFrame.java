package fr.afpa.pompey.cda22045.sparadrap.frame;

import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.service.*;
import fr.afpa.pompey.cda22045.sparadrap.dao.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class DetailClientFrame extends JFrame {
    private JComboBox listeClient;
    private JPanel detailClientPanel;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JLabel dateClient;
    private JLabel adresseClient;
    private JLabel postalClient;
    private JLabel villeClient;
    private JLabel secuClient;
    private JLabel mutuelleClient;
    private JLabel telClient;
    private JLabel mailclient;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField textNaissance;
    private JTextField textVille;
    private JTextField textPostal;
    private JTextField textMail;
    private JTextField textTelephone;
    private JTextField textAdresse;
    private JTextField textSecu;
    private JLabel medecinClient;
    private JButton btnRetour;
    private JLabel specialisteClient;
    private JButton btnModifier;
    private JTextField textId;
    private JComboBox comboMedecin;
    private JComboBox comboSpecialiste;
    private JComboBox comboMutuelle;
    private boolean isNomEditable = false;
    private ClientService clientService = new ClientService();
    private MedecinDAO medecinDAO = new MedecinDAO();
    private SpecialisteDAO specialisteDAO = new SpecialisteDAO();
    private MutuelleDAO mutuelleDAO = new MutuelleDAO();


    public DetailClientFrame() throws Exception {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        setTitle("Détail client");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(detailClientPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TODO

        for (Medecin medecins : medecinDAO.findAll()) {
            comboMedecin.addItem(medecins);
            comboMedecin.setSelectedIndex(-1);
        }
        for (Specialiste specialistes : specialisteDAO.findAll()) {
            comboSpecialiste.addItem(specialistes);
            comboSpecialiste.setSelectedIndex(-1);
        }
        for (Mutuelle mutuelle : mutuelleDAO.findAll()) {
            comboMutuelle.addItem(mutuelle);
            comboMutuelle.setSelectedIndex(-1);
        }
        for (Client clients : clientService.findAll()) {
            listeClient.addItem(clients.getNom());
            listeClient.setSelectedIndex(-1);
            listeClient.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clients.getNom().equals(listeClient.getSelectedItem())) {
                        textPrenom.setText(clients.getPrenom());
                        textNom.setText(clients.getNom());
                        try {
                            textNaissance.setText(clients.getDateNaissance());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        textId.setText(String.valueOf(clients.getPersonne().getPer_id()));
                        textTelephone.setText(clients.getTelephone());
                        textMail.setText(clients.getEmail());
                        textAdresse.setText(clients.getAdresse());
                        textPostal.setText(clients.getCodePostal());
                        textVille.setText(clients.getVille());
                        textSecu.setText(clients.getSecuSociale());
                        comboMutuelle.setSelectedItem(clients.getMutuelle());
                        comboMedecin.setSelectedItem(clients.getMedecin());
                        comboSpecialiste.setSelectedItem(clients.getSpecialiste());
                    }
                }
            });
        }
//        comboSpecialiste.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                GeneriqueFrame x = null;
//                try {
//                    x = new GeneriqueFrame(medecin.getNom, "Specialiste");
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                x.setVisible(true);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

//        textMedecin.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    GeneriqueFrame x = new GeneriqueFrame(textMedecin.getText(), "Medecin");
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                setVisible(true);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNom.setEditable(true);
                textPrenom.setEditable(true);
                textNaissance.setEditable(true);
                textTelephone.setEditable(true);
                textMail.setEditable(true);
                comboSpecialiste.setEditable(true);
                comboSpecialiste.setEnabled(false);
                textAdresse.setEditable(true);
                textPostal.setEditable(true);
                textVille.setEditable(true);
                textSecu.setEditable(true);
                comboMutuelle.setEditable(true);
                comboMedecin.setEditable(true);
                btnModifier.setText("Valider");
                int perId = Integer.parseInt(textId.getText());
                Object selectItem = comboMutuelle.getSelectedItem();
                long muId = ((Mutuelle) selectItem).getMut_id();
                Object selectItem1 = comboMedecin.getSelectedItem();
                long mId = ((Medecin) selectItem1).getMed_id();
                Object selectItem2 = comboSpecialiste.getSelectedItem();
                long sId = ((Specialiste) selectItem2).getSpe_id();
                if (isNomEditable == true) {
                    try {
                        Client cl = getClients(muId, mId, sId, perId);
                        clientService.modifierClient(cl);
                        JOptionPane.showMessageDialog(null, "Validé");
                        isNomEditable = false;
                    } catch (MyException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                isNomEditable = true;
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
    private Client getClients(long muId, long mId, long sId, int perId) {

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
