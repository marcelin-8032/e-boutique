package fr.eboutique.project.controller.admin;

import fr.eboutique.project.exception.DataBaseException;
import fr.eboutique.project.exception.PersonalException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.engine.model.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class AdminProduit implements HandlerExceptionResolver {

    @PostMapping
    public String ajouterProduit(Model model) {
        return "";
    }

    @DeleteMapping
    public String supprimerProduit(Long produitId, Model model, HttpServletRequest request) throws Exception {
        return "";
    }


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();
        PersonalException error = new PersonalException();

        if (ex instanceof DataBaseException) {

            error.setMessage("Vous ne pouvez pas supprimer un produit tant que vous n'avez pas effacé la commande client. Dans la commande client, ce produit existe.");
            modelAndView.addObject("personalError", error);
            modelAndView.setViewName("error_page");
            return modelAndView;
        }


        error.setMessage("Votre demande n'est pas valide. Veuillez saisir une demande valide.");
        modelAndView.addObject("personalError", error);
        modelAndView.setViewName("error_page");

        return modelAndView;
    }
}
