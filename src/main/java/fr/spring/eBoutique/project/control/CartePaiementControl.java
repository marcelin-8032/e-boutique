package fr.spring.eBoutique.project.control;



import fr.spring.eBoutique.project.dao.CartePaiementDaoImpl;
import fr.spring.eBoutique.project.model.CartePaiement;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CartePaiementControl implements ICartePaiementControl {

	private CartePaiementDaoImpl carteBlue= new CartePaiementDaoImpl();
	public  CartePaiementControl() {
		
	}
	
	@Override
	public CartePaiement getCartePaiment(Integer id) {
		
		try {
			return carteBlue.getCartePaiment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartePaiement> getCartesPaiment(Integer idUtilisateur) {
		
		try {
			return carteBlue.getCartesPaiment(idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement) {
		
		try {
			return carteBlue.addCartePaiement(cartePaiement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartePaiement;
	
	}

	@Override
	public void removeCartePaiement(Integer id) {
		try {
			carteBlue.removeCartePaiement(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
