package fr.spring.eBoutique.project.model;


import sun.security.x509.GeneralName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getRue() {
        return rue;
    }


    public void setRue(String rue) {
        this.rue = rue;
    }


    public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }


    public int getCodePostal() {
        return codePostal;
    }


    public void setCodePostal(int codePostal) {
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
