package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.CommandeDAO;
import fr.spring.eBoutique.project.model.Commande;

import java.util.List;

public class CommandeControl implements ICommandeControl {

	private CommandeDAO commdao = new CommandeDAO();
	
	public CommandeControl() {
		
	}
	
	@Override
	public Commande getCommande(Integer idUtilisatuer) {
		
		try {
			return commdao.getCommande(idUtilisatuer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commande addCommande(Commande commande) {
		
		try {
			return commdao.addCommande(commande);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commande;
	}

	@Override
	public List<Commande> getCommandes(Integer idUtilisatuer) {
		
		try {
			return commdao.getCommandes(idUtilisatuer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
