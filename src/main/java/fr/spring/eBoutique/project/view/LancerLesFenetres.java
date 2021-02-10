package fr.spring.eBoutique.project.view;


import fr.spring.eBoutique.project.BDD.DataSourceConnexion;
import fr.spring.eBoutique.project.control.UtilisateurControl;
import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.model.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;


public class LancerLesFenetres extends AbstractAction {

	private static final long serialVersionUID = 581077429362732317L;
	
	private Identification2 identif;
	private Enregistrer2 enregis;	
	
//--------------------------------------------------------------
	private Connection connexion= null;
	public LancerLesFenetres() {
		if (connexion == null) {
			try {
				connexion= DataSourceConnexion.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//--------------------------------------------------------------------------------
	public LancerLesFenetres(Identification2 identif, Enregistrer2 enregis, String texte) {
		super(texte);
		this.identif = identif;
		this.enregis= enregis;
	}
//------------------------------------------------------------------------------------	
	
	//identification2 windows
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (identif.getButtonLogin().isSelected()) {
			Utilisateur utilis = new Utilisateur();
			utilis.setLogin(identif.getLoginField().getText());
			utilis.setModePass(identif.getPasswordField().getText());	
		}
//-------------------------------------------------------------------
		//Enregistrer2 windows
		Integer numero = null, codePostal = null, age=null;
		try {
			numero=Integer.parseInt(enregis.getNumeroField().getText());
			codePostal = Integer.parseInt(enregis.getCodePostalField().getText());
			age=Integer.parseInt(enregis.getAgeField().getText());
		} catch (NumberFormatException except) {
			except.printStackTrace();
		}
//-------------------------------------------------------------------
		   Adresse adresse = new Adresse();
	       adresse.setNumero(numero);
	       adresse.setRue(enregis.getRueField().getText());
	       adresse.setVille(enregis.getVilleField().getText());
	       adresse.setCodePostal(codePostal);
//----------------------------------------------------------------------
		if (enregis.getBtnCreer().isSelected()) {
			
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setLogin(enregis.getLoginField().getText());
			utilisateur.setNom(enregis.getNomField().getText());
			utilisateur.setPrenom(enregis.getPrenomField().getText());
			utilisateur.setAge(age);
			utilisateur.setEmail(enregis.getEmailField().getText());
			utilisateur.setModePass(enregis.getModePasseField().getText());
			utilisateur.setRole(enregis.getComboBoxRole().toString());
			
			utilisateur.setAdresse(adresse);
		
		Utilisateur addedUtilisateur = null;
		
		try {
			/*UtilisateurControl utilis = new UtilisateurControl();
			addedUtilisateur = utilis.addUtilisateur(utilisateur);
			addedUtilisateur =utilis.getUtilisateurByEmail(email);
			addedUtilisateur=utilis.getUtilisateurById(id);
			addedUtilisateur=utilis.getUtilisateurByLogin(login);
			addedUtilisateur=utilis.updateUtilisateur(addedUtilisateur);
			addedUtilisateur=utilis.seConnecter(peseudo, password);
			addedUtilisateur=utilis.seDesinscrireUtilisateur(id);*/
			
		} catch (Exception except) {
			System.err.println(except);	
		}
		return;
	}
}
		
	}

