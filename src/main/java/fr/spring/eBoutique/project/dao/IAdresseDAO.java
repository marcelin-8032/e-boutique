package fr.spring.eBoutique.project.dao;

import fr.eboutique.project.entity.Adresse;

public interface IAdresseDAO {

	public Adresse getAdresse(Integer idUtilisateur);
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur);
	public void updateAdresse(Adresse adresse, Integer idUtilisateur);
	public void removeAdresse(Integer idUtilisateur);
	
	
	
	
}
