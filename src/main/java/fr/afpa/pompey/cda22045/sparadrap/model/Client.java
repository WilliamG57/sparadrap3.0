package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String secuSocial;
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


}
