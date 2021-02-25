package test;

import façade.Facade;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LoginTest {

    private static String GOODEMAIL = "BryanBSotomayor78@gmail.com";
    private static String GOODPASSWORD = "PoaLe8Oo";
    private static String BADEMAIL = "bademail@gmail.com";
    private static String BADPASSWORD = "badpassword";


    @Test
    public void testSuccessfulLogin(){
        boolean login = Facade.login(GOODEMAIL, GOODPASSWORD.toCharArray());
        assertEquals(true, login);
    }

    @Test
    public void testBadEmailLogin(){
        boolean login = Facade.login(BADEMAIL, GOODPASSWORD.toCharArray());
        assertEquals(false, login);
    }

    @Test
    public void testBadPasswordLogin(){
        boolean login = Facade.login(GOODEMAIL, BADPASSWORD.toCharArray());
        assertEquals(false, login);
    }


}
