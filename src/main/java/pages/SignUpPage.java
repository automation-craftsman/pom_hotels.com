package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;

    private By emailField = By.name("signupFormEmailInput");
    private By firstNameField = By.name("firstNameSignUp");
    private By surName = By.name("lastNameSignUp");
    private By passWord = By.name("passwordSingUpInput");
    private By submitButton = By.xpath("//*[@id=\"signupFormSubmitButton\"]");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillOutFormData(String email, String first_name, String last_name, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(firstNameField).sendKeys(first_name);
        driver.findElement(surName).sendKeys(last_name);
        driver.findElement(passWord).sendKeys(password);
    }

    public SignUpWelcomPage ContinueToSignUp(){
        // Waiting for the submit button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(submitButton)));

        // Clicking on the submit button
        driver.findElement(submitButton).click();

        return new SignUpWelcomPage(driver);
    }
}
