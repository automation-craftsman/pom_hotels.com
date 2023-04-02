package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpWelcomPage {
    private WebDriver driver;
    private By wctext = By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/h1");
    private By continueButton = By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/a");

    public SignUpWelcomPage(WebDriver driver){
        this.driver = driver;
    }

    public String getWelcomeText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(wctext)));
        return driver.findElement(wctext).getText();
    }

    public HomePage clickContinue(){
        driver.findElement(continueButton).click();

        return new HomePage(driver);
    }

}
