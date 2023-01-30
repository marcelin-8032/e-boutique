package fr.eboutique.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "panier")
public class Panier extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long panierId;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ArticleDePanier> articleDePaniers;

    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    private double total;


    @Override
    public String toString() {
        return "Panier{" +
                "articleDePaniers=" + articleDePaniers +
                ", client=" + client +
                ", total=" + total +
                '}';
    }
}
