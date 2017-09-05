package org.fundacionjala.todoist;

import org.fundacionjala.todoist.page.login.Login;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Simon on 04/09/2017.
 */
public class LoginTest {
    private Login  login;

    /**
     *
     */
    @Before
    public void setup() {
        login = new Login();
    }

    /**
     *
     */
    @Test
    public void testLoginInPage() {
        String email = "OvidioMiranda@fundacion-jala.org";
        String password = "2017.Atmt";
        login.loginAs(email, password);
        //assertTrue(driver.getTitle().contains("Todoist"));
    }
}
