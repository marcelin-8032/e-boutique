package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.Client;
import fr.spring.eBoutique.project.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientControl implements IClientControl {

    @Autowired
    public final IClientService clientService;

    public ClientControl(IClientService clientService) {
        this.clientService = clientService;
    }


    @Override
    public Client getClientById(Long id) {
        return clientService.getClientById(id);
    }

    @Override
    public Client addClient(Client client) {
        return clientService.addClient(client);
    }

    @Override
    public Client getClientByLogin(String login) {
        return clientService.getClientByLogin(login);
    }

    @Override
    public void updateClient(Client client) {
        clientService.updateClient(client);
    }

    @Override
    public void removeClient(Long id) {
        clientService.removeClient(id);
    }

    @Override
    public Client getClientParLoginEtModedePass(String login, String modeDepass) {
        return clientService.getClientParLoginEtModedePass(login, modeDepass);
    }
}
