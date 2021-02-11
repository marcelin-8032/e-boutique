package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import fr.spring.eBoutique.project.enums.Categorie;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = -1131908465506420255L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Integer id;

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

    public Produit(Integer id, String nom, String description, float prix, int remise, Categorie categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.remise = remise;
        this.categorie = categorie;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}