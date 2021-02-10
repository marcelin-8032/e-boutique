package fr.spring.eBoutique.project.control;

import fr.eboutique.project.dao.CartePaiementDao;
import fr.eboutique.project.entity.CartePaiement;

import java.util.List;

public class CartePaiementControl implements ICartePaiementControl {

	private CartePaiementDao carteBlue= new CartePaiementDao();
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
