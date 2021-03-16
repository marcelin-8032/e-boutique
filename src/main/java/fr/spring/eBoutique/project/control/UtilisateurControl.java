package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.model.Client;
import fr.spring.eBoutique.project.model.Utilisateur;
import fr.spring.eBoutique.project.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class UtilisateurControl {

    @Autowired
    private IClientService clientService;

    @Autowired
    public UtilisateurControl(IClientService clientService) {
        this.clientService = clientService;
    }

    public IClientService getClientService() {
        return clientService;
    }

    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client/enregistrement")
    public ModelAndView getEnregistrementForm() {
        Client client = new Client();
        Utilisateur utilisateur = new Utilisateur();
        Adresse adresse = new Adresse();
        client.setAdresse(adresse);
        client.setUtilisateur(utilisateur);
        return new ModelAndView("enregister", "client", client);
    }

    @RequestMapping(value = "client/enregistrement", method = RequestMethod.POST)
    public String enregistrementClient(@Valid @ModelAttribute(value = "client") Client client, Model model,
                                       BindingResult result) {
        if (result.hasErrors())
            return "enregistrement";
        clientService.addClient(client);
        model.addAttribute("enregistrementAvecSucces", "Entregitré avec success");
        return "login";
    }



}
