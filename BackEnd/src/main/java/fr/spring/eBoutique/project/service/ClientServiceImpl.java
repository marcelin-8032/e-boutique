package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Client;
import fr.spring.eBoutique.project.model.Utilisateur;
import fr.spring.eBoutique.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ClientServiceImpl implements IClientService {

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client getClientById(Long id) {
        return null;
    }

    @Override
    public Client addClient(Client client) {
        Utilisateur utilisateur=client.getUtilisateur();
        if (utilisateur.getModePass() != null) {
            String modepass = utilisateur.getModePass();
            utilisateur.setModePass(passwordEncoder.encode(modepass));
        }
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client getClientByLogin(String login) {
        return clientRepository.findClienByLogin(login);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getClientParLoginEtModedePass(String login, String modeDepass) {
        return clientRepository.findClientParLoginEtModedePass(login, modeDepass);
    }
}
