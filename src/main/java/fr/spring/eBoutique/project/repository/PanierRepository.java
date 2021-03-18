package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Panier;
import org.springframework.data.repository.CrudRepository;

public interface PanierRepository extends CrudRepository<Panier, Long> {
    Panier findUtilisatuerParId(Long id);
}
