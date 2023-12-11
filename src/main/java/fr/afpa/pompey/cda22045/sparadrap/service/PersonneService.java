package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;
import org.springframework.stereotype.Service;

@Service
public class PersonneService {
    private Personne personne;

    public PersonneService() {
    }

    public void ajouterPersonne(Personne personnes) throws MyException {
        //Before we validate
        validate(personnes);
        //store in DB
        //TODO
    }

    public void validate(Personne personnes) throws MyException {
        validateCodePostal(personnes.getCodePostal());
        validateVille(personnes.getVille());
        validateTelephone(personnes.getTelephone());
        validateEmail(personnes.getEmail());
    }

    protected void validateCodePostal(String codePostal) {
        try {
            if (!codePostal.matches("[0-9]{5}")) {
                throw new IllegalArgumentException("Le code postal n'est pas valide.");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de remplir le code postal.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le code postal n'est pas valide.");
        }
    }

    protected void validateVille(String ville) {
        try {
            if (ville.isEmpty()) {
                throw new NullPointerException("Merci de remplir une ville.");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de remplir une ville.");
        }
    }

    protected void validateTelephone(String telephone) {
        try {
            if (!telephone.matches("^(?:(?:\\+|00)33\\s?|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$")) {
                throw new IllegalArgumentException("Le numéro de téléphone est invalide");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de mettre un numéro de téléphone");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le numéro de téléphone est invalide");
        }
    }

    protected void validateEmail(String email) {
        try {
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("L'adresse email est invalide");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Merci de mettre une adresse email");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("L'adresse email est invalide");
        }
    }
}