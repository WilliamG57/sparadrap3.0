package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@Entity
@Table(name = "client")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Client extends Personne {
    private long medecin_id;
    private long specialiste_id;
    private long mutuelle_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private long cli_id;

    @Column(name = "cli_secu")
    private String secuSociale;

    @Column(name = "cli_datenaissance")
    private String dateNaissance;

    @OneToOne
    @JoinColumn(name = "per_id")
    private Personne personne;

    @OneToOne
    @JoinColumn(name = "mut_id")
    private Mutuelle mutuelle;

    @OneToOne
    @JoinColumn(name = "med_id")
    private Medecin medecin;

    @OneToOne
    @JoinColumn(name = "spe_id")
    private Specialiste specialiste;

    public Client() {
        super();
    }

    public Client(String nom, String prenom, String adresse, String codePostal, String ville,
                  String telephone, String email, String securiteSocial, String dateNaissance,
                  long mutuelle, long medecin, long specialiste) {
    }
}
