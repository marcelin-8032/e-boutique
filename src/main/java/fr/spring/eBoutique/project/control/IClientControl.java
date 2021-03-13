package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.Client;

public interface IClientControl {

    Client getClientById(Long id);

    Client addClient(Client client);

    Client getClientByLogin(String login);

    void updateClient(Client client);

    void removeClient(Long id);

    Client getClientParLoginEtModedePass(String login, String modeDepass);
}
