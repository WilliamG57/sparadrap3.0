package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private long id;

    @Column(name = "cli_secu")
    private String secuSocial;

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


}
