package fr.spring.eBoutique.project.control;

import fr.eboutique.project.entity.Commande;

import java.util.List;

public interface ICommandeControl {

	public Commande getCommande(Integer idUtilisatuer);
	public Commande addCommande (Commande commande);
	List<Commande> getCommandes(Integer idUtilisatuer);

	
}
