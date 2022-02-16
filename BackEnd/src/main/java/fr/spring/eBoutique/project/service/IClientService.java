package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Client;
import fr.spring.eBoutique.project.model.Utilisateur;

public interface IClientService {

    Client getClientById(Long id);

    Client addClient(Client client);

   Client getClientByLogin(String login);

    void updateClient(Client client);

    void removeClient(Long id);

    Client getClientParLoginEtModedePass(String login, String modeDepass);
}
