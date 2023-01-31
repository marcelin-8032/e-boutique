package fr.eboutique.project.controller;

import fr.eboutique.project.exception.PersonalException;
import fr.eboutique.project.model.Client;
import fr.eboutique.project.model.Utilisateur;
import fr.eboutique.project.service.IClientService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("client/panier")
public class PanierControl implements HandlerExceptionResolver {


    private final IClientService clientService;

    public PanierControl(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getPanier(@AuthenticationPrincipal Utilisateur actifUtilisatuer) {

        Client client = clientService.getClientByLogin(actifUtilisatuer.getLogin());
        long cartId = client.getPanier().getPanierId();

        return "redirect:/client/cartPaiement" + cartId;

    }

    @GetMapping("/{cartPaimentId}")
    public String getCartePaimentRedirect(@PathVariable(value = "cartPaimentId") Long cartPaimentId, Model model) {
        model.addAttribute("cartPaiementId", cartPaimentId);
        return "cartPaiement";
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
