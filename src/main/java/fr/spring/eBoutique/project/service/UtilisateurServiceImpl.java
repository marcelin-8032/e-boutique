package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Utilisateur;
import fr.spring.eBoutique.project.repository.UtilisateurRepositoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

    @Autowired
    private final UtilisateurRepositoy utilisateurRepositoy;

    public UtilisateurServiceImpl(UtilisateurRepositoy utilisateurRepositoy) {
        this.utilisateurRepositoy = utilisateurRepositoy;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepositoy.save(utilisateur);
    }

    @Transactional(readOnly = true)
    @Override
    public Utilisateur getUtilisateurById(Long id) {

        Optional<Utilisateur> utilisateurOptional = utilisateurRepositoy.findById(id);
        if (!utilisateurOptional.isPresent()) {
            throw new RuntimeException("Utilisatuer n'a pas trouvé");
        }
        return
                utilisateurOptional.get();
    }

    @Override
    public Utilisateur getUtilisateurByLogin(String login) {
        return utilisateurRepositoy.findUtilisatuerByLogin(login);
    }


    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        return utilisateurRepositoy.findUtilisatuerByEmail(email);
    }


    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurRepositoy.save(utilisateur);
    }

    @Override
    public void removeUtilisateur(Long id) {
        utilisateurRepositoy.deleteById(id);
    }

    @Override
    public void seDesinscrireUtilisateur(Long id) {
        utilisateurRepositoy.unSubscriberUtilisatuer(id);
    }

}
