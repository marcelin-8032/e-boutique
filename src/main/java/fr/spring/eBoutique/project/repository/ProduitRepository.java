package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

    List<Produit> findProductbyCategory(Categorie categorie);
}
