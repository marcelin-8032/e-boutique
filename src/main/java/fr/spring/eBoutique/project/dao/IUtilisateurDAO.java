package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.model.Utilisateur;

public interface IUtilisateurDAO<Login> {

	public Utilisateur getUtilisateurById (Long id);
	public Utilisateur getUtilisateurByLogin(String login);
	public Utilisateur getUtilisateurByEmail(String email);
	public Utilisateur  addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public void seDesinscrireUtilisateur (Integer id);
	public boolean seConnecter (String peseudo, String password);
}
