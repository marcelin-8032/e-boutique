package fr.spring.eBoutique.project.control;


import java.util.List;

public interface ILigneCommandeControl {

	List<LigneCommande> getLignesCommande(Long idCommande);
	LigneCommande addLigneCommande(LigneCommande ligneCommande);
	
}
