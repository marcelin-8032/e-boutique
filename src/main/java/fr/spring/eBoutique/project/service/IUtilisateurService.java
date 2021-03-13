package fr.spring.eBoutique.project.service;

import fr.spring.eBoutique.project.model.Utilisateur;

import java.util.Optional;

public interface IUtilisateurService {

    Utilisateur getUtilisateurById(Long id);

    Utilisateur addUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateurByEmail(String email);

    void updateUtilisateur(Utilisateur utilisateur);

    void removeUtilisateur(Long id);


}
