package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.CartePaiement;
import fr.spring.eBoutique.project.service.ICartePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartePaiementControl implements ICartePaiementControl {

    private final ICartePaiementService cartePaiementService;

    @Autowired
    public CartePaiementControl(ICartePaiementService cartePaiementService) {
        this.cartePaiementService = cartePaiementService;
    }

    @Override
    @GetMapping(value = "id")
    public CartePaiement getCartePaiment(@PathVariable("id") Long id) {
        return cartePaiementService.getCartePaiment(id);
    }

    @Override
    @GetMapping
    public List<CartePaiement> getAllCartesPaiment() {
        return cartePaiementService.getAllCartesPaiment();
    }

    @Override
    @PostMapping
    public CartePaiement addCartePaiement(@RequestBody  CartePaiement cartePaiement) {
        return cartePaiementService.addCartePaiement(cartePaiement);
    }

    @Override
    @DeleteMapping("{id}")
    public void removeCartePaiement(@PathVariable("id") Long id) {
        cartePaiementService.removeCartePaiement(id);
    }
}
