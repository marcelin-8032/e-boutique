package fr.spring.eBoutique.project.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.validation.constraints.Size;
import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "utilisateur")
@Proxy(lazy = false)
public class Utilisateur extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, length = 255)
    private Long id;

    @NotNull
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(name = "password", nullable = false)
    private String modePass;

    @Column(name = "actif")
    private boolean actif;

    @Column(name = "clientId")
    private Long clientId;

    public Utilisateur() {
        super();
    }


}
