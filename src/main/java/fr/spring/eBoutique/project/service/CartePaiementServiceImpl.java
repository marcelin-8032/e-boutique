package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.CartePaiement;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CartePaiementServiceImpl implements ICartePaiementService{
    @Override
    public CartePaiement getCartePaiment(Integer id) {
        return null;
    }

    @Override
    public List<CartePaiement> getCartesPaiment(Long idUtilisateur) {
        return null;
    }

    @Override
    public CartePaiement addCartePaiement(CartePaiement cartePaiement) {
        return null;
    }

    @Override
    public void removeCartePaiement(Long id) {

    }

    @Override
    public CartePaiement validate(String cartId) throws IOException {
        return null;
    }
}
