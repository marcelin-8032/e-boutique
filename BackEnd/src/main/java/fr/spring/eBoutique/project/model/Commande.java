package fr.spring.eBoutique.project.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Commandes")
public class Commande extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long commandId;

    @NotNull
    @Column(name = "creation_date_time", nullable = false)
    private LocalDateTime dateCreation;

    @NotNull
    @Column(name = "Deliveray_date_time", nullable = false)
    private LocalDateTime dateLivraison;

    @NotNull
    @Column(name = "Total_price", nullable = false)
    private float prix_total;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Client client;

    @OneToOne
    @JoinColumn(name="cartePaimentId")
    private Panier panier;

    @OneToOne
    @JoinColumn(name="adreseeId")
    private Adresse adresse;


}
