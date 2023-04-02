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
        assertTrue(home.GetUsersAvatarName().contains(user_name));
        home.LogOut();
    }

    @Test
    public void TestFailedLogIn(){
        var loginPage = homepage.GoToLoginPage();
        loginPage.FillLoginData(invalid_email, password);

    }

}


