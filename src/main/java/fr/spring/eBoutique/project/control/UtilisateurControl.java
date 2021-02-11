package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.dao.UtilisateurDAO;
import fr.spring.eBoutique.project.model.Utilisateur;

public class UtilisateurControl implements IUtilisateurControl {

	
	private UtilisateurDAO utilasDao = new UtilisateurDAO();
	public UtilisateurControl() {
		
	}

	@Override
	public Utilisateur getUtilisateurById(Long id) {
		try {
			return utilasDao.getUtilisateurById(id);
			
		} catch (Exception e) {
			System.out.println("error in get utilisatuer by id");
		}	
		return null;
	}

	@Override
	public Utilisateur getUtilisateurByLogin(String login) {
		
		try {
			return utilasDao.getUtilisateurByLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		
		try {
			return utilasDao.getUtilisateurByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		
		try {
			return utilasDao.addUtilisateur(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		
			try {
				utilasDao.updateUtilisateur(utilisateur);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void seDesinscrireUtilisateur(Integer id) {
		
		try {
			utilasDao.seDesinscrireUtilisateur(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean seConnecter(String peseudo, String password) {
		
		try {
			return utilasDao.seConnecter(peseudo, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
