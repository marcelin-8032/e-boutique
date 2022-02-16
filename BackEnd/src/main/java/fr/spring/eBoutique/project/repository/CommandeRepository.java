package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Commande;
import fr.spring.eBoutique.project.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {

    Commande getClientOrderBycart(Panier cart);
}
