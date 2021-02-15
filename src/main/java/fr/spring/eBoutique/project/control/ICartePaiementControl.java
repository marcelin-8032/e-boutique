package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.CartePaiement;

import java.util.List;

public interface ICartePaiementControl {

    CartePaiement getCartePaiment(Long id);

    List<CartePaiement> getAllCartesPaiment();

    CartePaiement addCartePaiement(CartePaiement cartePaiement);

    void removeCartePaiement(Long id);

}
