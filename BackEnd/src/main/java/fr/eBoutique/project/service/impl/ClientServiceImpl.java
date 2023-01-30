package fr.eBoutique.project.service.impl;

import fr.eboutique.project.repository.ClientRepository;
import fr.eboutique.project.model.Client;
import fr.eboutique.project.model.Utilisateur;
import fr.eboutique.project.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

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
