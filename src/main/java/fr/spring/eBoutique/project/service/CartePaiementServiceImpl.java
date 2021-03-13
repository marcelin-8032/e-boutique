package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;
import fr.spring.eBoutique.project.repository.CartePaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartePaiementServiceImpl implements ICartePaiementService {

    @Autowired
    private final CartePaiementRepository cartePaiementRepository;

    @Autowired
    private final CommandeServiceImpl commandeService;

    public CartePaiementServiceImpl(CartePaiementRepository cartePaiementRepository, CommandeServiceImpl commandeService) {
        this.cartePaiementRepository = cartePaiementRepository;
        this.commandeService = commandeService;

    }

    @Override
    public CartePaiement getCartePaiment(Long id) {
        return cartePaiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartePaiement> getAllCartesPaiment() {
        List<CartePaiement> cartePaiements = new ArrayList<>();
        cartePaiementRepository.findAll().forEach(cartePaiements::add);
        return cartePaiements;

    }

    @Override
    public CartePaiement addCartePaiement(CartePaiement cartePaiement) {

        return cartePaiementRepository.save(cartePaiement);
    }

    @Override
    public void removeCartePaiement(Long id) {
        cartePaiementRepository.deleteById(id);
    }

    @Override
    public CartePaiement updateCartePaiement(CartePaiement cartePaiement) {
        return cartePaiementRepository.save(cartePaiement);
    }

    @Override
    public CartePaiement validate(Long cartId) throws IOException {
        CartePaiement cartePaiement = getCartePaiment(cartId);

        if (cartePaiement == null || cartePaiement.getArticleList().size() == 0) {
            throw new IOException(cartId + " ");
        }
        updateCartePaiement(cartePaiement);
        return getCartePaiment(cartId);
    }
}
