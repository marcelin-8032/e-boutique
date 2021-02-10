package fr.spring.eBoutique.project.control;

import fr.eboutique.project.entity.LigneCommande;

import java.util.List;

public interface ILigneCommandeControl {

	List<LigneCommande> getLignesCommande(Integer idCommande);
	LigneCommande addLigneCommande(LigneCommande ligneCommande);
	

	
}
