package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Utilisateur;
import fr.spring.eBoutique.project.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilisateurControl implements IUtilisateurControl {

    private final IUtilisateurService utilisateurService;

    @Autowired
    public UtilisateurControl(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    @GetMapping(path = "{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @Override
    @GetMapping
    public Utilisateur getUtilisateurByLogin(@RequestBody String login) {
        return utilisateurService.getUtilisateurByLogin(login);
    }

    @Override
    @GetMapping
    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurService.getUtilisateurByEmail(email);
    }

    @Override
    @PostMapping
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.addUtilisateur(utilisateur);
    }

    @Override
    @PutMapping
    public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
    }

    @Override
    public void seDesinscrireUtilisateur(Long id) {
        utilisateurService.seDesinscrireUtilisateur(id);
    }

    @Override
    public boolean seConnecter(String peseudo, String password) {
        return utilisateurService.seConnecter(peseudo, password);
    }

}
