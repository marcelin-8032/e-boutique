package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.exception.PersonalException;
import fr.spring.eBoutique.project.model.Categorie;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "/produit")
public class ProduitControl implements HandlerExceptionResolver {

    @Autowired
    private IProduitService produitService;


    public Produit getProduit(Long id) {
        return produitService.getProduit(id);
    }

    public List<Produit> getProduitsByCategorie(Categorie categorie) {
        List<Produit> produits = new ArrayList<>();
        return produits;
    }

    public List<Produit> gettoutedProduit() {
        List<Produit> produits = new ArrayList<>();
        return produits;


    }

    public Produit addProduit(Produit produit) {
        return produit;
    }

    public void updateProduit(Produit produit) {

    }

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
