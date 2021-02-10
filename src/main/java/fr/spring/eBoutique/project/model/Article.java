package fr.spring.eBoutique.project.model;

public class Article {

	private Integer id;
	private Integer quantite;
	private Produit produit;
	private Utilisateur utilisateur;
	
	public Article() {
		super();
	}

	public Article(Integer quantite,Produit produit, Utilisateur utilisateur) {
		super();
		this.quantite = quantite;
		this.produit = produit;
		this.utilisateur = utilisateur;
	}

	public Integer getId() {
		return id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", quantite=" + quantite + ", produit=" + produit + ", utilisateur=" + utilisateur
				+ "]";
	}


	
}
