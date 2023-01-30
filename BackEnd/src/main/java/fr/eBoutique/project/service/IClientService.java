package fr.eboutique.project.service;

import fr.eboutique.project.model.Client;

public interface IClientService {

    Client getClientById(Long id);

    Client addClient(Client client);

   Client getClientByLogin(String login);

    void updateClient(Client client);

    void removeClient(Long id);

    Client getClientParLoginEtModedePass(String login, String modeDepass);
}
