package test;


import façade.Facade;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationTest {

    private static String USER_EMAIL = "MarcJBenton28@gmail.com";
    private static String USER_PASSWORD = "ih8ahToo";
    private static String USER_EMAIL2 = "BryanBSotomayor78@gmail.com";
    private static String USER_PASSWORD2 = "PoaLe8Oo";
    private static int ID_UTILISATEUR = 293094;
    private static int MAX_FILM = 1;
    private static int ID_FILM1 = 88247;
    private static int ID_FILM2 = 942385;


    @Before
    public void setUpTest(){
        Facade.login(USER_EMAIL, USER_PASSWORD.toCharArray());
    }

    @Test
    public void ALouerFilmTest(){
        assertTrue(Facade.locationExemplaire(ID_FILM1));
    }

    @Test
    public void BForfaitDepasseTest(){
        assertTrue(!Facade.locationExemplaire(ID_FILM2));
    }

    // On essaye de se connecter avec un autre utilisateur et de louer un film qui n'a plus d'exemplaire.
    @Test
    public void CExemplaireIndisponibleTest(){
        Facade.login(USER_EMAIL2, USER_PASSWORD.toCharArray());
        assertTrue(!Facade.locationExemplaire(ID_FILM1));
    }

}
