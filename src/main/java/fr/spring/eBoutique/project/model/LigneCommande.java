package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
public class LigneCommande extends BaseEntity {

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


    @Override
    public String toString() {
        return "LigneCommande [id=" + id + ", quantite=" + quantite + ", produit=" + produit + ", commande=" + commande
                + "]";
    }


}
