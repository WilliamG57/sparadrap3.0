package fr.afpa.pompey.cda22045.sparadrap.service;


import fr.afpa.pompey.cda22045.sparadrap.model.*;
import fr.afpa.pompey.cda22045.sparadrap.repository.ClientRepository;
import fr.afpa.pompey.cda22045.sparadrap.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService extends PersonneService {

    @Autowired
    private ClientRepository clientRepository;
//    ClientDAO clientDAO = new ClientDAO();
//    MedecinDAO medecinDAO = new MedecinDAO();
//    SpecialisteDAO specialisteDAO = new SpecialisteDAO();
//    MutuelleDAO mutuelleDAO = new MutuelleDAO();

    public ClientService() {
    }

    public Client save(Client client) throws MyException {
        validate(client);
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
            // Gérer le cas où le client n'existe pas
            return null;
        }
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

//    public void ajouterClient(Client client) throws MyException, SQLException {
//        validate(client);
//        personneDAO.transactionCreate(client);
//    }

//    public void supprimerClient(Client client) {
//        clientDAO.delete(client);
//    }

//    public void modifierClient(Client client) throws MyException, SQLException {
//        validate(client);
//        personneDAO.transactionUpdate(client);
//    }

//    public List<Client> findAll() {
//        try {
//            List<Client> clients = clientDAO.findAll();
//            for (Client cl : clients) {
//                Medecin m = medecinDAO.find(cl.getMedecin_id());
//                if (m != null) {
//                    cl.setMedecin(m);
//                }
//                Specialiste s = specialisteDAO.find(cl.getSpecialiste_id());
//                if (s != null) {
//                    cl.setSpecialiste(s);
//                }
//                Mutuelle mut = mutuelleDAO.find(cl.getMutuelle_id());
//                if (mut != null) {
//                    cl.setMutuelle(mut);
//                }
//            }
//            return clients;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
