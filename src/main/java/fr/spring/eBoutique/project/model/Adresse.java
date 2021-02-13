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


    public Adresse() {
        super();
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codePostal;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + numero;
        result = prime * result + ((rue == null) ? 0 : rue.hashCode());
        result = prime * result + ((ville == null) ? 0 : ville.hashCode());
        return result;
    }


}
