package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitControl implements IProduitControl {

    private final IProduitService produitService;

    @Autowired
    public ProduitControl(IProduitService produitService) {
        this.produitService = produitService;
    }


    @Override
    @GetMapping(path = "{id}")
    public Produit getProduit(@PathVariable Long id) {
        return produitService.getProduit(id);
    }

    @Override
    @GetMapping
    public List<Produit> getProduitsByCategorie(@RequestBody Categorie categorie) {
        return produitService.getProduitsByCategorie(categorie);
    }

    @Override
    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    @Override
    @PutMapping
    public void updateProduit(@RequestBody Produit produit) {
        produitService.updateProduit(produit);
    }

    @Override
    @DeleteMapping("{id}")
    public void removeProduit(@PathVariable("id") Long id) {
        produitService.removeProduit(id);
    }
}