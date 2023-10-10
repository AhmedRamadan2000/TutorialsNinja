package testcases;

import drivers.DriverFactory;
import jdk.jfr.FlightRecorder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;

@Listeners(listener.Listener.class)
public class TestBase {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeTest()
    public void setupChromeDriver(String browser) throws InterruptedException {

        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @AfterTest
    public void quite() {
        if (driver != null) {
            driver.quit();
            Thread.currentThread().interrupt();
        }
    }
}