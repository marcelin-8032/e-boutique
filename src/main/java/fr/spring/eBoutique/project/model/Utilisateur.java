package fr.spring.eBoutique.project.model;

import java.io.Serializable;
import java.util.List;

public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 9126054084816010164L;

    private Integer id;
    private String login;
    private String email;
    private String modePass;
    private String nom;
    private String prenom;
    private int age;
    private String telephone;
    private boolean actif;
    private String role;
    private List<Commande> listeCommandes;
    private List<CartePaiement> listeCartesPaiement;
    private Panier panier;
    private Adresse adresse;


    public Utilisateur() {
        super();
    }


    public Utilisateur(String login, String email, String modePass, String nom, String prenom, int age,
                       String telephone, boolean actif, String role, List<Commande> listeCommandes,
                       List<CartePaiement> listeCartesPaiement, Panier panier, Adresse adresse) {
        super();
        this.login = login;
        this.email = email;
        this.modePass = modePass;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.telephone = telephone;
        this.actif = actif;
        this.role = role;
        this.listeCommandes = listeCommandes;
        this.listeCartesPaiement = listeCartesPaiement;
        this.panier = panier;
        this.adresse = adresse;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
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


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
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


    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", login=" + login + ", email=" + email + ", modePass=" + modePass + ", nom="
                + nom + ", prenom=" + prenom + ", age=" + age + ", telephone=" + telephone + ", actif=" + actif
                + ", role=" + role + ", listeCommandes=" + listeCommandes + ", listeCartesPaiement="
                + listeCartesPaiement + ", panier=" + panier + ", adresse=" + adresse + "]";
    }


}
