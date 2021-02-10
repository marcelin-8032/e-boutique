package fr.spring.eBoutique.project.dao;



import fr.eboutique.project.entity.Utilisateur;

public interface IUtilisateurDAO<Login> {

	public Utilisateur getUtilisateurById (Integer id);
	public Utilisateur getUtilisateurByLogin(String login);
	public Utilisateur getUtilisateurByEmail(String email);
	public Utilisateur  addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public void seDesinscrireUtilisateur (Integer id);
	public boolean seConnecter (String peseudo, String password);
}
