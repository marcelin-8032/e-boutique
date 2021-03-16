package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProduitControl {

    @Autowired
    private IProduitService produitService;


    
    public ProduitControl(IProduitService produitService) {
        this.produitService = produitService;
    }

    public IProduitService getProduitService() {
        return produitService;
    }

    public void setProduitService(IProduitService produitService) {
        this.produitService = produitService;
    }


    @Bean   //uploading images and media
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(10240000);
        return resolver;
    }


    @PostMapping(value = "admin/prduit/addProduit")
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }





    @GetMapping(path = "getProduit/{id}")
    public ModelAndView getProduit(@PathVariable (value = "produitId") Long id) {
        Produit produit=produitService.getProduit(id);
        return new ModelAndView("produitPage","prduitObj",produit);
    }


    @GetMapping
    public List<Produit> getProduitsByCategorie(@RequestBody Categorie categorie) {
        return produitService.getProduitsByCategorie(categorie);
    }



    @PutMapping
    public void updateProduit(@RequestBody Produit produit) {
        produitService.updateProduit(produit);
    }

    @DeleteMapping("{id}")
    public void removeProduit(@PathVariable("id") Long id) {
        produitService.removeProduit(id);
    }
}