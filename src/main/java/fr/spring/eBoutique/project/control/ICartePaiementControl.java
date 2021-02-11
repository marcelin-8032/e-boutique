package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.model.CartePaiement;

import java.util.List;

public interface ICartePaiementControl {

    CartePaiement getCartePaiment(Integer id);

    List<CartePaiement> getCartesPaiment(Integer idUtilisateur);

    CartePaiement addCartePaiement(CartePaiement cartePaiement);

    void removeCartePaiement(Integer id);


}
