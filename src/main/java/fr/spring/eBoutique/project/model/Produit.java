package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="Produit")
public class Produit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name")
    private String nom;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private float prix;

    @Column(name = "discout")
    private int remise;

    @OneToOne
    private Categorie categorie;

    public Produit() {
    }

    public Produit(Long id, String nom, String description, float prix, int remise, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.remise = remise;
        this.categorie = categorie;
    }

}