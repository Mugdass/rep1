package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.CalculateForMonthlyPaymentPage;

public class BaseTest {
    protected static WebDriver driver;
    protected static CalculateForMonthlyPaymentPage calculateformonthlypaymentpage;

    @BeforeSuite
    public void setup() {
        // Detect if running in CI (GitHub Actions)
        boolean isCI = System.getenv("CI") != null;

        if (isCI) {
            // CI: Headless Chrome
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        } else {
            // Local: Safari (or change to Chrome if you prefer)
            driver = new SafariDriver();
            // Optional: for local Chrome
            // WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver();
        }

        driver.get("https://www.calculator.net/mortgage-calculator.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void getCalculateForMonthlyPaymentPage() {
        calculateformonthlypaymentpage = new CalculateForMonthlyPaymentPage(driver);
    }

    @AfterSuite
    public void quitDriver() {
        if (driver != null) driver.quit();
    }
}
