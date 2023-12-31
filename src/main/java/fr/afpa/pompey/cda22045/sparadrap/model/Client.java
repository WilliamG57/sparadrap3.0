package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
@EqualsAndHashCode(callSuper = true)
public class Client extends Personne {

    private long medecin_id;
    private long specialiste_id;
    private long mutuelle_id;


    @Column(name = "cli_secu")
    private String secuSociale;

    @Column(name = "cli_datenaissance")
    private String dateNaissance;

    @ManyToOne
    @JoinColumn(name = "mut_id")
    private Mutuelle mutuelle;

    @ManyToOne
    @JoinColumn(name = "med_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "spe_id")
    private Specialiste specialiste;


    public Client(String nom, String prenom, String adresse, String codePostal, String ville,
                  String telephone, String email, String securiteSocial, String dateNaissance,
                  long mutuelle, long medecin, long specialiste) {
    }
}
