package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Utilisateur;

public interface IUtilisateurControl {

    Utilisateur getUtilisateurById(Long id);

    Utilisateur getUtilisateurByEmail(String email);

    Utilisateur addUtilisateur(Utilisateur utilisateur);

    void updateUtilisateur(Utilisateur utilisateur);


}
