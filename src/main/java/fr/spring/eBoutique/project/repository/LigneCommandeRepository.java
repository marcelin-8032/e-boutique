package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.LigneCommande;
import org.springframework.data.repository.CrudRepository;

public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Long> {
}
