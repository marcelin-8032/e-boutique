package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Utilisateur;
import fr.spring.eBoutique.project.service.UtilisateurServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class UtilisateurControl implements IUtilisateurControl {

	
private final UtilisateurServiceImpl utilisateurService;
	public UtilisateurControl(UtilisateurServiceImpl utilisateurService) {

		this.utilisateurService = utilisateurService;
	}

	@Override
	public Utilisateur getUtilisateurById(Long id) {

		return null;
	}

	@Override
	public Utilisateur getUtilisateurByLogin(String login) {

		return null;
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {

		return null;
	}

	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {

		return utilisateur;
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {

	}

	@Override
	public void seDesinscrireUtilisateur(Integer id) {
		

	}

	@Override
	public boolean seConnecter(String peseudo, String password) {

		return false;
	}

}
