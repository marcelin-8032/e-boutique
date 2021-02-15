package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.LigneCommandeDAO;
import fr.spring.eBoutique.project.model.LigneCommande;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class LigneCommandeControl implements ILigneCommandeControl {

	@Override
	public List<LigneCommande> getLignesCommande(Integer idCommande) {

			return null;
}
	
	@Override
	public LigneCommande addLigneCommande(LigneCommande ligneCommande) {

		return ligneCommande;
	}

}
