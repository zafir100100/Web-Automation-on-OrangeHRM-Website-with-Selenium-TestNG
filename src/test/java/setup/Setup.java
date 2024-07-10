package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import models.ApplicationConfiguration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.AppConfigLoader;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;
    public ApplicationConfiguration config;
    @BeforeTest
    public void setup(){
        config = AppConfigLoader.getConfig();
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080)); // Set the window size directly
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils.takeScreenshot(driver);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }

        }

    }
    @AfterTest
    public void quitBrowser(){
        try{
            driver.close();
        }
        catch (Exception e){
            driver.quit();
        }

    }
}
