package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Specialiste extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long spe_id;

    private String specialite;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Personne personne;
}
