package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.CommandeDAOImpl;
import fr.spring.eBoutique.project.model.Commande;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommandeControl implements ICommandeControl {

	
	@Override
	public Commande getCommande(Integer idUtilisatuer) {

		return null;
	}

	@Override
	public Commande addCommande(Commande commande) {

		return commande;
	}

	@Override
	public List<Commande> getCommandes(Integer idUtilisatuer) {

		return null;
	}

}
