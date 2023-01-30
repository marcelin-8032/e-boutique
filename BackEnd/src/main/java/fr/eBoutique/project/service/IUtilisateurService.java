package fr.eboutique.project.service;

import fr.eboutique.project.model.Utilisateur;

public interface IUtilisateurService {

    Utilisateur getUtilisateurById(Long id);

    Utilisateur addUtilisateur(Utilisateur utilisateur);

    Utilisateur getUtilisateurByEmail(String email);

    void updateUtilisateur(Utilisateur utilisateur);

    void removeUtilisateur(Long id);


}
