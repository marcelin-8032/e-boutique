package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.LigneCommande;

import java.util.List;

public interface ILigneCommandeControl {

	List<LigneCommande> getLignesCommande(Long idCommande);
	LigneCommande addLigneCommande(LigneCommande ligneCommande);
	
}
