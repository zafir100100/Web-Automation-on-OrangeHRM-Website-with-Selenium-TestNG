package testrunner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class UserUpdateTestRunner extends Setup {
    @Test
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        String fileName = "./src/test/resources/Users.json";
        List data = Utils.readJSONArray(fileName);
        JSONObject userObj = (JSONObject) data.get(0);
        String userName = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(userName, password);
        // wait for page loading
        Thread.sleep(4000);
        // navigate from dashboard to my info page
        driver.findElements(By.className("oxd-main-menu-item-wrapper")).get(2).click();
        // wait for page loading
        Thread.sleep(4000);
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "viewPersonalDetails";
        Assert.assertTrue(urlActual.contains(urlExpected));
    }

    @Test
    public void updateUserInfo() {
        List<WebElement> headerTitle = driver.findElements(By.className("orangehrm-main-title"));
        Utils.waitForElement(driver, headerTitle.get(0), 50);
        if (headerTitle.get(0).isDisplayed()) {
            EmployeePage employeePage = new EmployeePage(driver);
            employeePage.dropdownBox.get(0).click();
            employeePage.dropdownBox.get(0).sendKeys("b");
            employeePage.dropdownBox.get(0).sendKeys(Keys.ARROW_DOWN);
            employeePage.dropdownBox.get(0).sendKeys(Keys.ARROW_DOWN);
            employeePage.dropdownBox.get(0).sendKeys(Keys.ENTER);
            // scroll dowm amd click
            Utils.doScrollDown(driver);
            List<WebElement> buttons = driver.findElements(By.cssSelector("[type=submit]"));
            buttons.get(1).click();
        }
    }

    @AfterTest
    public void logout(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.btnProfileIcon.click();
        driver.findElement(By.partialLinkText("Logout")).click();
    }
}
