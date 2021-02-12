package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.model.Utilisateur;

public interface IUtilisateurDAO<Login> {

	Utilisateur getUtilisateurById (Long id);
	Utilisateur getUtilisateurByLogin(String login);
	Utilisateur getUtilisateurByEmail(String email);
	Utilisateur  addUtilisateur(Utilisateur utilisateur);
	void updateUtilisateur(Utilisateur utilisateur);
	void seDesinscrireUtilisateur (Integer id);
	boolean seConnecter (String peseudo, String password);
}
