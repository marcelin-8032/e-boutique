package fr.spring.eBoutique.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
public class Client extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String login;

    @NotEmpty
    private String modepass;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String nom;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String prenom;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String telephone;

    private boolean actif;

    @Valid
    @OneToOne
    @JoinColumn(name ="addresse")
    private Adresse adresse;

    @OneToOne
    @JoinColumn(name = "cartePaimentId")
    private CartePaiement cartePaiement;

}
