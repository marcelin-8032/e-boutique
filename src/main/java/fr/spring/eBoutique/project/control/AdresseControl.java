package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.AdresseDAO;
import fr.spring.eBoutique.project.model.Adresse;

public class AdresseControl implements IAdresseControl {

	private AdresseDAO adreDAO= new AdresseDAO();
	
	public AdresseControl() {
		
	}
	@Override
	public Adresse getAdresse(Long idUtilisateur) {
	
		try {
			return adreDAO.getAdresse(idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Adresse addAdresse(Adresse adresse, Integer idUtilisateur) {
		try {
			return adreDAO.addAdresse(adresse, idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateAdresse(Adresse adresse, Integer idUtilisateur) {
		try {
			adreDAO.updateAdresse(adresse, idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeAdresse(Integer idUtilisateur) {
		try {
			adreDAO.removeAdresse(idUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
