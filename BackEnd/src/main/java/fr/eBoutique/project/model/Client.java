package fr.eboutique.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String nom;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String prenom;

    @NotEmpty
    @Size(min=5,max=30)
    private String login;

    @NotEmpty
    @Size(min=6,max=30)
    private String modepass;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="addresse")
    private Adresse adresse;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "utilisatuerId")
    private Utilisateur utilisateur;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "cartePaimentId")
    private Panier panier;


    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse=" + adresse +
                ", utilisateur=" + utilisateur +
                ", panier=" + panier +
                '}';
    }
}
