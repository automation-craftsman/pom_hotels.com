package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private By homeSignInButton = By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button");
    private By modalSignInButton = By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[1]");
    private By homeModalSignUpButton = By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[1]/div/div/a[2]");
    private By avatarName = By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/button");
    private By logoutButton = By.xpath("//*[@id=\"gc-custom-header-nav-bar-acct-menu\"]/div/div[3]/a[6]");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public SignUpPage GoToSignUpPage(){
        driver.findElement(homeSignInButton).click();
        driver.findElement(homeModalSignUpButton).click();

        return new SignUpPage(driver);
    }

    public String GetUsersAvatarName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(avatarName)));
        return driver.findElement(avatarName).getText();
    }

    public LoginPage GoToLoginPage(){
        driver.findElement(homeSignInButton).click();
        driver.findElement(modalSignInButton).click();

        return new LoginPage(driver);
    }

    public void LogOut(){
        driver.findElement(avatarName).click();
        driver.findElement(logoutButton).click();
    }
}
