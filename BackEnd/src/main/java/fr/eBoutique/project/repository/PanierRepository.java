package fr.eboutique.project.repository;

import fr.eboutique.project.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends CrudRepository<Panier, Long> {
    Panier findUtilisatuerParId(Long id);
}
