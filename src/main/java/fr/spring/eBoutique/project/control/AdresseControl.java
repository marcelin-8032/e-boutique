package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.AdresseDAOImpl;
import fr.spring.eBoutique.project.model.Adresse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdresseControl implements IAdresseControl {

	private AdresseDAOImpl adreDAO= new AdresseDAOImpl();
	
	public AdresseControl() {
			}


	@Override
	@RequestMapping
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
