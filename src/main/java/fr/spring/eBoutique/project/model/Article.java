package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @NotNull
    @Column(name = "quantity")
    private Integer quantite;

    @ManyToOne
    private Produit produit;

    @OneToMany
    private Utilisateur utilisateur;

    @NotNull
    @Column(name = "prix_article")
    private Float prix_unit;

    public Article() {
        super();
    }

    public Article(Long id, @NotNull Integer quantite, @NotNull Produit produit, @NotNull Utilisateur utilisateur, @NotNull Float prix_unit) {
        this.id = id;
        this.quantite = quantite;
        this.produit = produit;
        this.utilisateur = utilisateur;
        this.prix_unit = prix_unit;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Integer getQuantite() {
//        return quantite;
//    }
//
//    public void setQuantite(Integer quantite) {
//        this.quantite = quantite;
//    }
//
//    public Produit getProduit() {
//        return produit;
//    }
//
//    public void setProduit(Produit produit) {
//        this.produit = produit;
//    }
//
//    public Utilisateur getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(Utilisateur utilisateur) {
//        this.utilisateur = utilisateur;
//    }
//
//    public Float getPrix_unit() {
//        return prix_unit;
//    }
//
//    public void setPrix_unit(Float prix_unit) {
//        this.prix_unit = prix_unit;
//    }
}
