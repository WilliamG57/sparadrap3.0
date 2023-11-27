package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private long id;

    @Column(name = "per_nom")
    private String nom;

    @Column(name = "per_prenom")
    private String prenom;

    @Column(name = "per_telephone")
    private String telephone;

    @Column(name = "per_email")
    private String email;

    @Column(name = "per_adr")
    private String adresse;

    @Column(name = "per_codepostal")
    private String codePostal;

    @Column(name = "per_ville")
    private String ville;
}
