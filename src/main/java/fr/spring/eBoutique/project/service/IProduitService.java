package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Produit;

import java.util.List;

public interface IProduitService {

    Produit getProduit(Long id);

    List<Produit> getProduitsByCategorie(String categorie);

    Produit addProduit(Produit produit);

    void updateProduit(Produit produit);

    void removeProduit(Long id);


}
