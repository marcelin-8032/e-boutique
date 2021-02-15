package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepositoy extends CrudRepository<Utilisateur, Long> {
}
