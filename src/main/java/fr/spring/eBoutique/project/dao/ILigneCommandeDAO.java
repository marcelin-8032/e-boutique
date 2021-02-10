package fr.spring.eBoutique.project.dao;

import fr.eboutique.project.entity.LigneCommande;

import java.util.List;

public interface ILigneCommandeDAO {

	List<LigneCommande> getLignesCommande(Integer idCommande);
	LigneCommande addLigneCommande(LigneCommande ligneCommande);
	

	
}
