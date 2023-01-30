package fr.eboutique.project.model;


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

    @Column(name = "Postal_Code", nullable = false)
    private int codePostal;

    @Column(name = "City", nullable = false, length = 45)
    private String ville;

    @Column(name = "City", nullable = false, length = 45)
    private String pays;

    @Override
    public String toString() {
        return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
                + codePostal + "]";
    }

}
