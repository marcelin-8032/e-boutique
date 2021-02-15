package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;

import java.io.IOException;
import java.util.List;

public interface ICartePaiementService {

    CartePaiement getCartePaiment(Integer id);

    List<CartePaiement> getCartesPaiment(Long idUtilisateur);

    CartePaiement addCartePaiement(CartePaiement cartePaiement);

    void removeCartePaiement(Long id);

    CartePaiement validate(String cartId) throws IOException;



}
