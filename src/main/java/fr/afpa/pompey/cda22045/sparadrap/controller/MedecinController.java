package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Medecin;
import fr.afpa.pompey.cda22045.sparadrap.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping("/medecin")
    public String showMedecin(Model model) {
        List<Medecin> medecins = medecinService.getAllMedecin();
        model.addAttribute("medecins", medecins);
        System.out.println("hello world");
        return "medecin";
    }
}
