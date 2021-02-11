package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import fr.spring.eBoutique.project.tools.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class LigneCommande extends BaseEntity {

    private static final long serialVersionUID = -3531853028647584857L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="article")
    @ManyToOne
    private Article article;

    @NotNull
    @Column(name="quantite")
    private Long quantite;

    private Produit produit;
    private Commande commande;

    public LigneCommande() {
        super();
    }

    public LigneCommande(Long quantite, Produit produit, Commande commande) {
        super();
        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
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
