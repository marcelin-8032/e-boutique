package fr.spring.eBoutique.project.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Commandes")
@NamedQueries({
        @NamedQuery(name = "findCommandByName", query = "from Commande c where c.name=: name"),
        @NamedQuery(name = "findCommandeAll", query = "from Commande")
})
public class Commande extends BaseEntity {

    private static final long serialVersionUID = -189145911845731690L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @NotNull
    @Column(name = "creation_date_time", nullable = false)
    private LocalDateTime dateCreation;


    @NotNull
    @Column(name = "Deliveray_date_time", nullable = false)
    private LocalDateTime dateLivraison;

    @NotNull
    @Column(name = "Total_price", nullable = false)
    private float prix_total;


    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Utilisateur utilisateur;

    @ManyToOne
    private List<LigneCommande> listeLignesCommande = new ArrayList<>();


    public Commande() {
    }

    public Commande(Long id, LocalDateTime dateCreation, LocalDateTime dateLivraison, float prix_total, Utilisateur utilisateur, List<LigneCommande> listeLignesCommande) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.dateLivraison = dateLivraison;
        this.prix_total = prix_total;
        this.utilisateur = utilisateur;
        this.listeLignesCommande = listeLignesCommande;
    }


    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", dateLivraison=" + dateLivraison +
                ", prix_total=" + prix_total +
                ", utilisateur=" + utilisateur +
                ", listeLignesCommande=" + listeLignesCommande +
                '}';
    }
}
