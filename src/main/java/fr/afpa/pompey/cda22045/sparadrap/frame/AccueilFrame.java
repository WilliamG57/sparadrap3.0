package fr.afpa.pompey.cda22045.sparadrap.frame;


import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilFrame extends JFrame {
    private JButton btnAchat;
    private JPanel accueilChoix;
    private JButton btnClient;
    private JButton btnHistorique;
    private JButton btnQuitter;
    private JButton btnOrdonnance;
    private JButton btnCreate;

    public static void designAccueil() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        AccueilFrame x = new AccueilFrame();
        x.setSize(1000, 600);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
        x.getContentPane().add(x.accueilChoix);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public AccueilFrame() {

        btnAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AchatsFrame y = null;
                try {
                    y = new AchatsFrame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });

        btnOrdonnance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AchatOrdonnanceFrame y = null;
                try {
                    y = new AchatOrdonnanceFrame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });
        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailClientFrame y = null;
                try {
                    y = new DetailClientFrame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateClientFrame y = null;
                try {
                    y = new CreateClientFrame();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                y.setVisible(true);
                dispose();
            }
        });

        btnHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HistoriqueFrame y = new HistoriqueFrame();
                y.setVisible(true);
                dispose();
            }
        });
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Singleton.closeInstanceDB();
                dispose();
            }
        });
    }
}
