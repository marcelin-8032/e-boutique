package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;

import java.io.IOException;
import java.util.List;

public interface ICartePaiementService {

    CartePaiement getCartePaiment(Long id);

    List<CartePaiement> getAllCartesPaiment();

    CartePaiement addCartePaiement(CartePaiement cartePaiement);

    void removeCartePaiement(Long id);

    CartePaiement validate(String cartId) throws IOException;



}
