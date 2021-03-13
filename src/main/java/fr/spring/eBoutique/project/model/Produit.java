package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Entity
@Table(name = "Produit")
public class Produit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;

    @NotEmpty
    @Column(name = "name")
    private String nom;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private Float prix;

    @NotNull
    @Column(name = "discout")
    private int remise;

    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Article> articles;

}