package fr.eboutique.project.repository;

import fr.eboutique.project.model.Commande;
import fr.eboutique.project.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

    Commande getClientOrderBycart(Panier cart);
}
