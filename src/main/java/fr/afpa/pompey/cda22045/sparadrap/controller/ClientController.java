package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Client;
import fr.afpa.pompey.cda22045.sparadrap.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String showClient(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }
}
