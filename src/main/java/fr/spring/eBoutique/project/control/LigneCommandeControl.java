package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.LigneCommandeDAO;
import fr.spring.eBoutique.project.model.LigneCommande;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class LigneCommandeControl implements ILigneCommandeControl {
	private LigneCommandeDAO ligneCD = new LigneCommandeDAO();
	public LigneCommandeControl() {
		
	}

	@Override
	public List<LigneCommande> getLignesCommande(Integer idCommande) {
		
		try {
			return ligneCD.getLignesCommande(idCommande);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
}
	
	@Override
	public LigneCommande addLigneCommande(LigneCommande ligneCommande) {
		
		try {
			return ligneCD.addLigneCommande(ligneCommande);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ligneCommande;
	}

}
