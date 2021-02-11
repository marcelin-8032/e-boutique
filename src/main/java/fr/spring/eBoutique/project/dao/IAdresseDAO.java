package fr.spring.eBoutique.project.dao;


import fr.spring.eBoutique.project.model.Adresse;

public interface IAdresseDAO {

	public Adresse getAdresse(Long idUtilisateur);
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur);
	public void updateAdresse(Adresse adresse, Integer idUtilisateur);
	public void removeAdresse(Integer idUtilisateur);
	
	
	
	
}
