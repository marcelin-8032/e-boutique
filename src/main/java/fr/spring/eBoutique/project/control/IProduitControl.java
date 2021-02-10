package fr.spring.eBoutique.project.control;

import fr.eboutique.project.entity.Produit;

import java.util.List;

public interface IProduitControl {

	Produit getProduit(Integer id);
	List<Produit> getProduitsByCategorie(String categorie);
	Produit addProduit(Produit produit);
	void updateProduit(Produit produit);
	void removeProduit(Integer id);

}
