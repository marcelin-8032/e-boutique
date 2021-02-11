package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Utilisateur;

public interface IUtilisateurControl {

    Utilisateur getUtilisateurById(Integer id);

    Utilisateur getUtilisateurByLogin(String login);

    Utilisateur getUtilisateurByEmail(String email);

    Utilisateur addUtilisateur(Utilisateur utilisateur);

    void updateUtilisateur(Utilisateur utilisateur);

    void seDesinscrireUtilisateur(Integer id);

    boolean seConnecter(String peseudo, String password);

}
