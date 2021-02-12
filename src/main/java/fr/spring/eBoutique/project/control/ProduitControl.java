package fr.spring.eBoutique.project.control;



import fr.spring.eBoutique.project.dao.ProduitDAOImpl;
import fr.spring.eBoutique.project.model.Produit;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitControl implements IProduitControl {

	private ProduitDAOImpl prDao = new ProduitDAOImpl();
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