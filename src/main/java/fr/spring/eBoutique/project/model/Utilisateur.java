package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import fr.spring.eBoutique.project.tools.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Proxy(lazy = false)
public class Utilisateur extends BaseEntity {

    private static final long serialVersionUID = 9126054084816010164L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @NotNull
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
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

    private boolean actif;

    private String role;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Utilisateur_id")
    private List<Commande> listeCommandes = new ArrayList<>();

    @ManyToOne
    private List<CartePaiement> listeCartesPaiement;

    @OneToOne
    private Panier panier;

    @OneToOne
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModePass() {
        return modePass;
    }

    public void setModePass(String modePass) {
        this.modePass = modePass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance.toString();
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = String.valueOf(LocalDate.parse(date_de_naissance));
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public List<CartePaiement> getListeCartesPaiement() {
        return listeCartesPaiement;
    }

    public void setListeCartesPaiement(List<CartePaiement> listeCartesPaiement) {
        this.listeCartesPaiement = listeCartesPaiement;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
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
