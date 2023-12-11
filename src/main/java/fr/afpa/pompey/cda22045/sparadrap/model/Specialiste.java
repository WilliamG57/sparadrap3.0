package fr.afpa.pompey.cda22045.sparadrap.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Specialiste extends Personne {

    private String specialite;

}
