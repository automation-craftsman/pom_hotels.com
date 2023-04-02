package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        // Settings to bypass chromedriver issues with 111.* driver
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

        // initiating and launching chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // maximizing browser window
        driver.manage().window().maximize();
        // launching test application
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hotels.com");
        driver.getTitle();

        // initiating HomePage object to start with
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void tarDown(){
        driver.quit();
    }
}
