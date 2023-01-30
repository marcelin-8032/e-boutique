package fr.eboutique.project.repository;

import fr.eboutique.project.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepositoy extends CrudRepository<Utilisateur, Long> {

    Utilisateur findUtilisatuerByEmail(String email);


}
