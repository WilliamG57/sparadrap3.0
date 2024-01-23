package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.repository.ClientRepository;
import fr.afpa.pompey.cda22045.sparadrap.repository.MedecinRepository;
import fr.afpa.pompey.cda22045.sparadrap.repository.MutuelleRepository;
import fr.afpa.pompey.cda22045.sparadrap.repository.SpecialisteRepository;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService extends PersonneService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private SpecialisteRepository specialisteRepository;
    @Autowired
    private MutuelleRepository mutuelleRepository;

    public ClientService() {
    }

    public Client save(Client client) throws MyException {
        validate(client);

        Long medecinId = client.getMedecinId();
        Long specialisteId = client.getSpecialisteId();
        Long mutuelleId = client.getMutuelleId();

        Medecin medecin = (medecinId != null) ? medecinRepository.findById(medecinId).orElse(null) : null;
        Specialiste specialiste = (specialisteId != null) ? specialisteRepository.findById(specialisteId).orElse(null) : null;
        Mutuelle mutuelle = (mutuelleId != null) ? mutuelleRepository.findById(mutuelleId).orElse(null) : null;

        client.setMedecin(medecin);
        client.setSpecialiste(specialiste);
        client.setMutuelle(mutuelle);

        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Long id, Client updatedClient) {
        if (clientRepository.existsById(id)) {
            updatedClient.setPer_id(id);
            return clientRepository.save(updatedClient);
        } else {
            return null;
        }
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public void validate(Client client) throws MyException {
        validateSecuriteSociale(client.getSecuSociale());
        validateDateNaissance(client.getDateNaissance());
        validateCodePostal(client.getCodePostal());
        validateVille(client.getVille());
        validateTelephone(client.getTelephone());
        validateEmail(client.getEmail());
    }

    private void validateDateNaissance(String dateNaissance) throws MyException {
        DateManagment.parse(dateNaissance, "La date de naissance n'est pas au bon format");
    }

    private void validateSecuriteSociale(String securiteSociale) throws MyException {
        try {
            if (securiteSociale.length() != 15) {
                throw new MyException("Le numéro de sécurité sociale doit contenir 15 chiffres");
            }

            for (int i = 0; i < securiteSociale.length(); i++) {
                if (securiteSociale.charAt(i) < '0' || securiteSociale.charAt(i) > '9') {
                    throw new MyException("Le numéro de sécurité sociale doit être composé uniquement de chiffres.");
                }
            }
        } catch (NullPointerException e) {
            throw new MyException("Merci de mettre un numéro de sécurité sociale");
        }
    }
}
