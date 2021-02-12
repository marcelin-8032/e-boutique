package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.CommandeDAOImpl;
import fr.spring.eBoutique.project.model.Commande;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommandeControl implements ICommandeControl {

	private CommandeDAOImpl commdao = new CommandeDAOImpl();
	
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
