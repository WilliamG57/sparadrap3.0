package fr.afpa.pompey.cda22045.sparadrap.controller;

import fr.afpa.pompey.cda22045.sparadrap.model.Client;
import fr.afpa.pompey.cda22045.sparadrap.service.ClientService;
import fr.afpa.pompey.cda22045.sparadrap.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updateClient) {
        return clientService.updateClient(id, updateClient);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client newClient) throws MyException {
        Client createClient = clientService.save(newClient);
        return ResponseEntity.ok(createClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        boolean isRemoved = clientService.deleteClient(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}