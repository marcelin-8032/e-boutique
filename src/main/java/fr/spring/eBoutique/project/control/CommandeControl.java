package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Commande;
import fr.spring.eBoutique.project.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CommandeControl implements ICommandeControl {

    private final ICommandeService commandeService;

    @Autowired
    public CommandeControl(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Override
    @GetMapping(path= "id")
    public Commande getCommande(@PathVariable("id") Long idUtilisatuer) {
        return commandeService.getCommande(idUtilisatuer);
    }

    @Override
    @PostMapping
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }

    @Override
    @GetMapping (path="{idUtilisatuer}/Commande")
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }
}
