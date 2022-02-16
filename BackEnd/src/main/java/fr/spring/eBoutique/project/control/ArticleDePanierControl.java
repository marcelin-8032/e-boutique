package fr.spring.eBoutique.project.control;

import fr.spring.eBoutique.project.exception.PersonalException;
import fr.spring.eBoutique.project.model.*;
import fr.spring.eBoutique.project.service.IArticleDePanierService;
import fr.spring.eBoutique.project.service.IClientService;
import fr.spring.eBoutique.project.service.IPanierService;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ArticleDePanierControl implements HandlerExceptionResolver {

    @Autowired
    private IPanierService panierService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IProduitService produitService;

    @Autowired
    private IArticleDePanierService articleService;


    @GetMapping(path = "{idUtilisateur}/articles")
    public List<ArticleDePanier> getArticles() {
        return articleService.getArticles();
    }


    @PostMapping(value = "add/{produitId}")
    public void addArticle(@PathVariable("produitId") Long produitId, @AuthenticationPrincipal Utilisateur utilisateur) {
        Client client = clientService.getClientByLogin(utilisateur.getLogin());
        Panier panier = client.getPanier();
        Produit produit = produitService.getProduit(produitId);

        List<ArticleDePanier> articleDePaniers = panier.getArticleDePaniers();

        //si produit deja exist
        for (int i = 0; i < articleDePaniers.size(); i++) {


            if (produit.getProduitId() == articleDePaniers.get(i).getProduit().getProduitId()) {
                ArticleDePanier articleDePanier = articleDePaniers.get(i);
                articleDePanier.setQuantite(articleDePanier.getQuantite() + 1);
                articleDePanier.setPrix_total(produit.getPrix() * articleDePanier.getQuantite());
                articleService.addArticle(articleDePanier);
                return ;
            }
        }

        //si produit est nouveu
        ArticleDePanier articleDePanier=new ArticleDePanier();
        articleDePanier.setProduit(produit);
        articleDePanier.setQuantite(1);
        articleDePanier.setPrix_total(produit.getPrix()*articleDePanier.getQuantite());
        articleDePanier.setPanier(panier);
        articleService.addArticle(articleDePanier);

    }

    @DeleteMapping(value = "/remove/{produitId")
    public void removeArticle(@PathVariable("produitId") Long produitId) {


    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void clear(@PathVariable(value = "panierId") Long id) {
        Panier panier = panierService.getPanierById(id);
        articleService.clear(panier);
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
