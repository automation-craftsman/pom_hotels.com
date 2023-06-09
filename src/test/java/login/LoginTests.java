package login;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends BaseTests {

    String user_name = "gunokigi";
    String email = "gunokigi@tutuapp.bid";
    String invalid_email = "whatever@gmail.com";
    String password = "$LmXzw8WDcY^";

    @Test
    public void TestSuccessfulLogIn(){
        var loginPage = homepage.GoToLoginPage();
        loginPage.FillLoginData(email, password);
        var home = loginPage.ClickSignInButton();

        // Checking the login status by comparing the user avatar name and the first name of the logged user
        assertTrue(home.GetUsersAvatarName().contains(user_name));
        home.LogOut();
    }

    @Test
    public void TestFailedLogIn(){
        var loginPage = homepage.GoToLoginPage();
        loginPage.FillLoginData(invalid_email, password);

        // Rest of the method is still incomplete

    }

}


