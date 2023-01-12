package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @Test(priority = 1)
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "dashboard";
        Assert.assertTrue(urlActual.contains(urlExpected));
    }


    @Test(priority = 2)
    public void doesProfileImageExist() {
        // implementation style like junit
//        WebElement imgProfile = driver.findElement(By.className("oxd-userdropdown-img"));
//        Assert.assertTrue(imgProfile.isDisplayed());
        // current implementation
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.imgProfile.isDisplayed());
    }

    @Test(priority = 3)
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
    }

    @Test(priority = 4)
    public void listEmployee() {
        Utils.doScroll(driver);
        WebElement table = driver.findElement(By.className("oxd-table-body"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role=roww]"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.cssSelector("[role=cell]"));
            Assert.assertTrue(cells.get(5).getText().contains("Full-Time Contract"));
        }
    }
}
