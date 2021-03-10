package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "utilisateur")
@Proxy(lazy = false)
public class Utilisateur extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @NotNull
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(name = "password", nullable = false)
    private String modePass;


    @NotNull
    @Column(name = "name")
    private String nom;

    @NotNull
    @Column(name = "first_name")
    private String prenom;

    @Column(name = "birth_day")
    private String date_de_naissance;

    @Column(name = "telephone")
    private int telephone;

    @Column(name = "actif")
    private boolean actif;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Utilisateur_id")
    private List<Commande> listeCommandes = new ArrayList<>();

    @ManyToOne
    private List<CartePaiement> listeCartesPaiement;

    @OneToOne
    private Panier panier;

    @ManyToOne
    private Adresse adresse;

    public Utilisateur() {
        super();
    }


    public Utilisateur(Long id, String login, String email, @Size(min = 8, max = 15) String modePass, String nom, String prenom, String date_de_naissance, int telephone, boolean actif, String role, List<Commande> listeCommandes, List<CartePaiement> listeCartesPaiement, Panier panier, Adresse adresse) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.modePass = modePass;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.actif = actif;
        this.role = role;
        this.listeCommandes = listeCommandes;
        this.listeCartesPaiement = listeCartesPaiement;
        this.panier = panier;
        this.adresse = adresse;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", modePass='" + modePass + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_de_naissance=" + date_de_naissance +
                ", telephone=" + telephone +
                ", actif=" + actif +
                ", role='" + role + '\'' +
                ", listeCommandes=" + listeCommandes +
                ", listeCartesPaiement=" + listeCartesPaiement +
                ", panier=" + panier +
                ", adresse=" + adresse +
                '}';
    }
}
