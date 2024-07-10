package testrunner;

import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest(description = "Visiting the Website")
    public void visitURL(){
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test(priority = 1, description = "Admin login with wrong credentials")
    public void doLoginWithInvalidCredentials() throws InterruptedException {
        loginPage=new LoginPage(driver);
        loginPage.doLogin("Adm","admin12");
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "dashboard";
        Assert.assertTrue(urlActual.contains(urlExpected));
        Allure.description("Login with Invalid Credentials");
    }

    @Test(priority = 2, description = "Admin log in successfully")
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "dashboard";
        Assert.assertTrue(urlActual.contains(urlExpected));
        Allure.description("Admin logged in successfully");
    }

    @Test(priority = 3, description = "Software OS version is visible")
    public void getSoftwareVersion() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getOsVersion().contains("OS"));
        Allure.description("Software OS version is visible");
    }
}
