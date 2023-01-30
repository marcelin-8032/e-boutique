package fr.eboutique.project.controller;


import fr.eboutique.project.enums.Categorie;
import fr.eboutique.project.exception.PersonalException;
import fr.eboutique.project.model.Produit;
import fr.eboutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/produit")
public class ProduitControl implements HandlerExceptionResolver {


    private IProduitService produitService;

    @Autowired
    public ProduitControl(IProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public Produit getProduit(Long id) {
        return produitService.getProduit(id);
    }

    @GetMapping
    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        List<Produit> produits = new ArrayList<>();
        return produits;
    }

    @GetMapping
    public List<Produit> gettoutedProduit() {
        List<Produit> produits = new ArrayList<>();
        return produits;
    }

    @PostMapping
    public Produit addProduit(Produit produit) {
        return produit;
    }

    @PutMapping
    public void updateProduit(Produit produit) {

    }

    @DeleteMapping
    public void removeProduit(Long id) {
    }


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        PersonalException error = new PersonalException();

        error.setMessage("Votre demande n'est pas valide.Veuillez entrer une demande valide.");
        modelAndView.addObject("personalException", error);
        modelAndView.setViewName("error_page");
        return modelAndView;
    }
}
