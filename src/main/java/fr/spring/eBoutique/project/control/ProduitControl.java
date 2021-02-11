package fr.spring.eBoutique.project.control;



import fr.spring.eBoutique.project.dao.ProduitDAO;
import fr.spring.eBoutique.project.model.Produit;

import java.util.List;

public class ProduitControl implements IProduitControl {

	private ProduitDAO prDao = new ProduitDAO();
	public ProduitControl() {
	}
	
	@Override
	public Produit getProduit(Integer id) {
		
		try {
			return prDao.getProduit(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> getProduitsByCategorie(String categorie) {
		
		try {
			return prDao.getProduitsByCategorie(categorie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produit addProduit(Produit produit) {
		
		try {
			return prDao.addProduit(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public void updateProduit(Produit produit) {
		
		try {
			prDao.updateProduit(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeProduit(Integer id) {
		
		try {
			prDao.removeProduit(id);
		} catch (Exception e) {
			e.printStackTrace();
	 }

  }
}