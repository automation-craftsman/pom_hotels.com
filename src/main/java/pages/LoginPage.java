package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By loginPageEmailField = By.xpath("//*[@id=\"loginFormEmailInput\"]");
    private By loginPagePasswordField = By.xpath("//*[@id=\"loginFormPasswordInput\"]");
    private By loginPageSignInButton = By.xpath("//*[@id=\"loginFormSubmitButton\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void FillLoginData(String email, String password){
        driver.findElement(loginPageEmailField).sendKeys(email);
        driver.findElement(loginPagePasswordField).sendKeys(password);
    }

    public HomePage ClickSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginPageSignInButton)));
        driver.findElement(loginPageSignInButton).click();

        return new HomePage(driver);
    }
}
