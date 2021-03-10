package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

    List<Produit> findProductbyCategory(Categorie categorie);
}
