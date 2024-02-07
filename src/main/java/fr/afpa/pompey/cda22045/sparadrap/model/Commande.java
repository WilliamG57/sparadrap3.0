package fr.afpa.pompey.cda22045.sparadrap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long com_id;

    @ManyToOne
    @JoinColumn(name = "per_id")
    private Client client;

    @Column
    private String date;

    @Column
    private Boolean Ordonnance;
}