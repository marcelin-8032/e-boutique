package fr.spring.eBoutique.project.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilisateurTest {

    Utilisateur utilisateur;

    @Before
    public void setUp() throws Exception {
        utilisateur=new Utilisateur();
    }

    @Test
    public void setLogin() {
        String login="md@yahoo.com";
        Utilisateur loginUser=new Utilisateur();
        loginUser.setLogin("md@yahoo.com");
        Assert.assertEquals(loginUser.getLogin(),login);
    }

    @Test
    public void getAdresse() {
    }
}