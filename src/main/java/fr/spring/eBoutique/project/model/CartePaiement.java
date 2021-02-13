package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "carte_paiement")
public class CartePaiement extends BaseEntity {

    private static final long serialVersionUID = -4424444347307311208L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotNull
    @Column(name = "carte_numero", nullable = false, unique = true)
    private int numero;


    @NotNull
    @Column(name = "date_validite")
    private LocalDate dateValidite;


    @NotNull
    @Column(name = "crypto_number")
    @Size(min = 3)
    private int cryptogramme;

    @NotNull
    @OneToMany
    private Utilisateur utilisateur;

    public CartePaiement() {
    }

    public CartePaiement(Long id, @NotNull int numero, @NotNull LocalDate dateValidite, @Size(min = 3) @NotNull int cryptogramme, @NotNull Utilisateur utilisateur) {
        this.id = id;
        this.numero = numero;
        this.dateValidite = dateValidite;
        this.cryptogramme = cryptogramme;
    }

    @Override
    public String toString() {
        return "CartePaiement{" +
                "id=" + id +
                ", numero=" + numero +
                ", dateValidite=" + dateValidite +
                ", cryptogramme=" + cryptogramme +
                ", utilisateur=" + utilisateur +
                '}';
    }
}


