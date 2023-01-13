package testrunner;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.util.List;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1, description = "User can not login with wrong credential")
    public void doLoginWithWrongCreds() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        loginPage.doLogin("wrongUser", "password");
        String validationErrorActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String validationErrorExpected = "Invalid credentials";
        Assert.assertTrue(validationErrorActual.contains(validationErrorExpected));
        Allure.description("Admin failed to log in");
    }

    @Test(priority = 2, description = "Admin log in successfully")
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "dashboard";
        Assert.assertTrue(urlActual.contains(urlExpected));
        Allure.description("Admin logged in successfully");
    }

    @Test(priority = 3, description = "Admin profile image showing")
    public void doesProfileImageExist() {
        // implementation style like junit
//        WebElement imgProfile = driver.findElement(By.className("oxd-userdropdown-img"));
//        Assert.assertTrue(imgProfile.isDisplayed());
        // current implementation
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.imgProfile.isDisplayed());
        Allure.description("Admin profile image is exists");
    }

    @Test(priority = 4, description = "Select employee status")
    public void selectEmploymentStatus() throws InterruptedException {
        dashboardPage = new DashboardPage(driver);
        // click on pim menu
        dashboardPage.sideNavs.get(1).click();
        // handling ajax dropdown
        // click on employee dropdown
        dashboardPage.dropdowns.get(0).click();
        // 2 times arrow down, (we cant click
        // because it gets disabled)
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ENTER);
        dashboardPage.btnSubmit.click();
        Thread.sleep(3000);
        List<WebElement> txtData = driver.findElements(By.tagName("span"));
        String dataActual = txtData.get(14).getText();
        String dataExpected = "Records Found";
        Assert.assertTrue(dataActual.contains(dataExpected));
        Allure.description("Data found");
    }

    @Test(priority = 5, description = "Showing employee list")
    public void listEmployee() {
        Utils.doScrollDown(driver);
        WebElement table = driver.findElement(By.className("oxd-table-body"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role=roww]"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.cssSelector("[role=cell]"));
            Assert.assertTrue(cells.get(5).getText().contains("Full-Time Contract"));
        }
        Allure.description("Employee list showing properly");
    }

    @Test(priority = 6, description = "Showing no employee data if not in database")
    public void noEmployeeData() throws InterruptedException {
        Utils.doScrollUp(driver);
        Thread.sleep(2000);
        dashboardPage = new DashboardPage(driver);
        // it takes time to click and scroll down
        dashboardPage.dropdowns.get(0).click();
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dashboardPage.dropdowns.get(0).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        dashboardPage.btnSubmit.click();
        Thread.sleep(2000);

        String dataStatusActual = driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();
        String dataStatusExpected = "No Records Found";
        Assert.assertEquals(dataStatusActual, dataStatusExpected);

        Allure.description("No employee in list");
    }
}
