package fr.spring.eBoutique.project.model;

import java.io.Serializable;

public class LigneCommande implements Serializable {

    private static final long serialVersionUID = -3531853028647584857L;

    private Integer id;
    private Integer quantite;
    private Produit produit;
    private Commande commande;

    public LigneCommande() {
        super();
    }

    public LigneCommande(Integer quantite, Produit produit, Commande commande) {
        super();
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "LigneCommande [id=" + id + ", quantite=" + quantite + ", produit=" + produit + ", commande=" + commande
                + "]";
    }


}
