package fr.eboutique.project.repository;

import fr.eboutique.project.enums.Categorie;
import fr.eboutique.project.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {

    List<Produit> findProductbyCategory(Categorie categorie);
}
