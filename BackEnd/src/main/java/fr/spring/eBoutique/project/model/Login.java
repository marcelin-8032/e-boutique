package fr.spring.eBoutique.project.model;

import javax.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

@Getter
@Setter
@Entity
@Table(name = "logins")
public class Login {

    @Id
    @Column(nullable = false, length = 64)
    private String series;

    @Column(nullable = false, length = 64)
    private String login;

    @Column(nullable = false, length = 64)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dernier_utilisation", nullable = false)
    private Date date;

    public Login() {
    }

    public Login(PersistentRememberMeToken token) {
        this.series = token.getSeries();
        this.login = token.getUsername();
        this.token = token.getTokenValue();
        this.date = token.getDate();
    }
}
