package fr.eboutique.project.controller;


import fr.eboutique.project.model.Commande;
import fr.eboutique.project.service.ICommandeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeControl implements HandlerExceptionResolver {

    private final ICommandeService commandeService;

    public CommandeControl(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping(path = "id")
    public Commande getCommande(@PathVariable("id") Long idUtilisatuer) {
        return commandeService.getCommande(idUtilisatuer);
    }


    @PostMapping
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }


    @GetMapping(path = "{idUtilisatuer}/Commande")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }
}
