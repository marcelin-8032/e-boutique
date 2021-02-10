package fr.spring.eBoutique.project.control;

import fr.eboutique.project.dao.LigneCommandeDAO;
import fr.eboutique.project.entity.LigneCommande;

import java.util.List;

public class LigneCommandeControl implements fr.eboutique.project.metier.ILigneCommandeControl {
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
