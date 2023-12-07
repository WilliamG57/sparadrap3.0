package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long per_id;

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
