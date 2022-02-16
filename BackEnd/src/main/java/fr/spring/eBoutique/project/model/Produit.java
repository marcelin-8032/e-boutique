package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Produit")
public class Produit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long produitId;

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

    @Transient
    private MultipartFile imagePrduit;

    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ArticleDePanier> articles;

}