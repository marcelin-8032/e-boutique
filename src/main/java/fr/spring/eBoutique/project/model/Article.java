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

}
