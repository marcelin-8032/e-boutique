package fr.spring.eBoutique.project.model;


import java.io.Serializable;
import java.util.List;


public class Commande implements Serializable {


	private static final long serialVersionUID = -189145911845731690L;
	
	private Integer id;
	private String dateCreation;
	private String dateLivraison;
	private float prix_total;
	
	private List<LigneCommande> listeLignesCommande;
	private Utilisateur utilisateur;
	
	public Commande() {
		super();
	}

	public Commande(String dateCreation, String dateLivraison, float prix_total,
			List<LigneCommande> listeLignesCommande, Utilisateur utilisateur) {
		super();
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.prix_total = prix_total;
		this.listeLignesCommande = listeLignesCommande;
		this.utilisateur = utilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public String getDateLivraison() {
		return dateLivraison;
	}

	public float getPrix_total() {
		return prix_total;
	}

	public List<LigneCommande> getListeLignesCommande() {
		return listeLignesCommande;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public void setPrix_total(float prix_total) {
		this.prix_total = prix_total;
	}

	public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
		this.listeLignesCommande = listeLignesCommande;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCreation=" + dateCreation + ", dateLivraison=" + dateLivraison
				+ ", prix_total=" + prix_total + ", listeLignesCommande=" + listeLignesCommande + ", utilisateur="
				+ utilisateur + "]";
	}

	

	
	
}
