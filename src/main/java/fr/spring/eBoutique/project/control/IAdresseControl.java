package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;

public interface IAdresseControl {

	public Adresse getAdresse(Integer idUtilisateur);
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur);
	public void updateAdresse(Adresse adresse, Integer idUtilisateur);
	public void removeAdresse(Integer idUtilisateur);
	
	
}
