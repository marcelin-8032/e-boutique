package fr.eboutique.project.service;

import fr.eboutique.project.enums.Categorie;
import fr.eboutique.project.model.Produit;

import java.util.List;

public interface IProduitService {
    Produit getProduit(Long id);
    List<Produit> getProduitsByCategorie(Categorie categorie);
    List<Produit> gettoutedProduit();
    Produit addProduit(Produit produit);
    void updateProduit(Produit produit);
    void removeProduit(Long id);

}
