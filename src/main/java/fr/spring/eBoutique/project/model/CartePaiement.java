package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "carte_paiement")
public class CartePaiement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long cartePaiementId;

    @NotNull
    @Column(name = "carte_numero", nullable = false, unique = true)
    private int numero;

    @NotNull
    @Column(name = "nom_sur_carte", nullable = false, unique = true)
    private String nomeSurCarte;

    @NotNull
    @Column(name = "crypto_number")
    @Size(min = 3)
    private int cryptogramme;

    @OneToMany(mappedBy = "cartepaiment",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Article> articleList;

    @OneToOne
    @JoinColumn(name="clientId")
    private Client client;

    public CartePaiement() {
    }

    @Override
    public String toString() {
        return "CartePaiement{" +
                "cartePaiementId=" + cartePaiementId +
                ", numero=" + numero +
                ", nomeSurCarte='" + nomeSurCarte + '\'' +
                ", cryptogramme=" + cryptogramme +
                ", client=" + client +
                '}';
    }
}



