package fr.eboutique.project.model;

import org.junit.Before;
import org.junit.Test;


public class AdresseTest {

    Adresse adresse;

    @Before
    public void setUp() throws Exception {
        adresse = new Adresse();
    }

    @Test
    public void getVille() throws Exception {
        String ville = "abcd";
        Utilisateur utilisateur=new Utilisateur();
        adresse.setVille("abcd");
       // Assert.assertEquals(utilisateur.getAdresse(),ville);
    }


    @Test
    public void getUtilisateur() {


    }
}