package fr.eboutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.validation.constraints.Size;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "utilisateurs")
@Proxy(lazy = false)
public class Utilisateur extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long utilisatuerId;

    @NotNull
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(name = "password", nullable = false)
    private String modePass;

    @Column(name = "actif")
    private boolean actif;

    @OneToOne
    private Client client;

    public Utilisateur() {
        super();
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "login='" + login + '\'' +
                ", modePass='" + modePass + '\'' +
                ", actif=" + actif +
                ", client=" + client +
                '}';
    }
}
