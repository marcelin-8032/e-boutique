package fr.spring.eBoutique.project.repository;

import fr.spring.eBoutique.project.model.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit, Long> {
}
