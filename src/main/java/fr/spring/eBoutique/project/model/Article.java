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

    @ManyToOne
    @JoinColumn(name = "cartePaiementId")
    private CartePaiement cartePaiement;


}
