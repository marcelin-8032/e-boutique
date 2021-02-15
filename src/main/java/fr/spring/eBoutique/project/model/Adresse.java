package fr.spring.eBoutique.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "adresse")
public class Adresse extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number", nullable = false)
    private int numero;

    @Column(name = "Rue", nullable = false, length = 45)
    private String rue;

    @Column(name = "City", nullable = false, length = 45)
    private String ville;

    @Column(name = "Postal_Code", nullable = false)
    private int codePostal;

    @OneToMany
    private Utilisateur utilisateur;

    public Adresse() {
        super();
    }

    public Adresse(Long id, int numero, String rue, String ville, int codePostal, Utilisateur utilisateur) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.utilisateur = utilisateur;
    }

    public Adresse(int numero, String rue, String ville, int codePostal) {
        super();
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
                + codePostal + "]";
    }


}
