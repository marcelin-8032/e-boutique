package fr.eboutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "articles")
public class ArticleDePanier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produitId")
    private Produit produit;

    @NotNull
    @Column(name = "quantity")
    private Integer quantite;

    @NotNull
    @Column(name = "prix_article")
    private Float prix_unit;

    @NotNull
    @Column(name = "prix_total")
    private Float prix_total;

    @ManyToOne//with cart
    @JoinColumn(name="panierId")//primaru key of cart
    private Panier panier;


    @Override
    public String toString() {
        return "ArticleDePanier{" +
                "produit=" + produit +
                ", quantite=" + quantite +
                ", prix_unit=" + prix_unit +
                ", prix_total=" + prix_total +
                '}';
    }
}
