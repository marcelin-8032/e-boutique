package fr.spring.eBoutique.project.control;



import fr.spring.eBoutique.project.dao.ProduitDAOImpl;
import fr.spring.eBoutique.project.model.Produit;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitControl implements IProduitControl {

	
	@Override
	public Produit getProduit(Integer id) {

		return null;
	}

	@Override
	public List<Produit> getProduitsByCategorie(String categorie) {

		return null;
	}

	@Override
	public Produit addProduit(Produit produit) {

		return produit;
	}

	@Override
	public void updateProduit(Produit produit) {

	}

	@Override
	public void removeProduit(Integer id) {


  }
}