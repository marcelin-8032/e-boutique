package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;
import fr.spring.eBoutique.project.repository.CartePaiementRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ICartePaiementService {

    CartePaiement getCartePaiment(Long id);

    List<CartePaiement> getAllCartesPaiment();

    CartePaiement addCartePaiement(CartePaiement cartePaiement);

    void removeCartePaiement(Long id);

    CartePaiement updateCartePaiement(CartePaiement cartePaiement);

    CartePaiement validate(Long cartId) throws IOException;

}
