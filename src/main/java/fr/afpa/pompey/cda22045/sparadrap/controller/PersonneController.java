package fr.afpa.pompey.cda22045.sparadrap.controller;


import fr.afpa.pompey.cda22045.sparadrap.model.Personne;
import fr.afpa.pompey.cda22045.sparadrap.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/*")
    public String showPersonne(Model model) {
        List<Personne> personnes = personneService.getAllPersonne();
        model.addAttribute("personnes", personnes);
        return "medecin";
    }
}
