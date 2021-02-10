package fr.spring.eBoutique.project.model;

import java.io.Serializable;

public class Produit implements Serializable{
	
	private static final long serialVersionUID = -1131908465506420255L;
	
	private Integer id;
	private String nom;
	private String description;
	private float prix;
	private int remise;
	private String categorie;
	
	public Produit() {
		super();
	}

	public Produit(String nom, String description, float prix, int remise, String categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.categorie = categorie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public float getPrix() {
		return prix;
	}

	public int getRemise() {
		return remise;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", categorie=" + categorie + "]";
	}

	

}