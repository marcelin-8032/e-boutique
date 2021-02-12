package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Utilisateur;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return null;
    }

    @Override
    public Utilisateur getUtilisateurByLogin(String login) {
        return null;
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        return null;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {

    }

    @Override
    public void seDesinscrireUtilisateur(Long id) {

    }

    @Override
    public boolean seConnecter(String peseudo, String password) {
        return false;
    }
}
