package fr.spring.eBoutique.project.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<LigneCommande> getListeLignesCommande() {
        return listeLignesCommande;
    }

    public void setListeLignesCommande(List<LigneCommande> listeLignesCommande) {
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
