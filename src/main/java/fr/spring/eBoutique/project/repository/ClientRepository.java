package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findClienByLogin(String login);
    Client findClientParLoginEtModedePass(String login, String modeDepass);
}
