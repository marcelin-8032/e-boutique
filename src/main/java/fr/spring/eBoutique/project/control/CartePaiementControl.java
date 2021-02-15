package fr.spring.eBoutique.project.control;



import fr.spring.eBoutique.project.dao.CartePaiementDaoImpl;
import fr.spring.eBoutique.project.model.CartePaiement;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CartePaiementControl implements ICartePaiementControl {


	
	@Override
	public CartePaiement getCartePaiment(Integer id) {

		return null;
	}

	@Override
	public List<CartePaiement> getCartesPaiment(Integer idUtilisateur) {

		return null;
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) {

		return cartePaiement;
	
	}

	@Override
	public void removeCartePaiement(Integer id) {

	}

}
