package fr.spring.eBoutique.project.model;

import java.io.Serializable;

public class CartePaiement implements Serializable{

	private static final long serialVersionUID = -4424444347307311208L;
	
	private Integer id;
	private int numero;
	private String dateValidite;
	private int cryptogramme;
	
	public CartePaiement() {
		super();
	}

	public CartePaiement(int numero, String dateValidite, int cryptogramme) {
		super();
		this.numero = numero;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Integer getId() {
		return id;
	}

	public int getNumero() {
		return numero;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public int getCryptogramme() {
		return cryptogramme;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

	public void setCryptogramme(int cryptogramme) {
		this.cryptogramme = cryptogramme;
	}


}
