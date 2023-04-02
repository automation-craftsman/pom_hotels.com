package signup;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class SignUpTests extends BaseTests {

    private String email = "gunokigi@tutuapp.bid";
    private String first_name = "gunokigi";
    private String last_name = "utuapp.bid";
    private String password = "$LmXzw8WDcY^";

    @Test
    public void testSignUp(){
        var signuppage = homepage.GoToSignUpPage();
        signuppage.fillOutFormData(email, first_name, last_name, password);
        var signupwelcomepage = signuppage.ContinueToSignUp();
        var confirmation_text = signupwelcomepage.getWelcomeText();

        // Checking successful sign up by comparing welcome message
        assertTrue(confirmation_text.contains("Welcome"));
        var homePage = signupwelcomepage.clickContinue();

        // Checking the login status by comparing the user avatar name and the first name of the logged user
        assertTrue(homePage.GetUsersAvatarName().contains(first_name));

        homePage.LogOut();
    }
}

