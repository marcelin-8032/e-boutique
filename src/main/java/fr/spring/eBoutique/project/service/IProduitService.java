package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitService {

    Optional<Produit> getProduit(Long id);

    List<Produit> getProduitsByCategorie(Categorie categorie);

    Produit addProduit(Produit produit);

    void updateProduit(Produit produit);

    void removeProduit(Long id);


}
