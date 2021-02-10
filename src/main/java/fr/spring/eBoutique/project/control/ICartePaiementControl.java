package fr.spring.eBoutique.project.control;

import fr.eboutique.project.entity.CartePaiement;

import java.util.List;

public interface ICartePaiementControl {

	public CartePaiement getCartePaiment(Integer id);
	public List<CartePaiement> getCartesPaiment (Integer idUtilisateur);
	public CartePaiement addCartePaiement (CartePaiement cartePaiement);
	public void removeCartePaiement(Integer id);
	
	
	
	
	
	
}
