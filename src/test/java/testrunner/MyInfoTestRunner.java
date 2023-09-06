package testrunners;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import setup.Setup;

import java.time.Duration;

public class MyInfoTestRunner extends Setup {

    @BeforeTest
    public void doLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage = new LoginPage(driver);
        String adminUser = "Admin";
        String adminPass = "admin123";
        loginPage.doLogin(adminUser, adminPass);
        Thread.sleep(1000);
    }

    @BeforeTest
    public void navigateToMyInfoPage() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.sideNavs.get(5).click();
    }

    @Test(priority = 1, description = "My Info page is fully loaded")
    public void verifyCurrentUrl() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "viewPersonalDetails";
        Assert.assertTrue(urlActual.contains(urlExpected));
        Allure.description("My Info page is fully loaded");
    }

    @Test(priority = 2, description = "Date of Birth field is filled in")
    public void verifyDateOfBirth() throws InterruptedException {
        Thread.sleep(3000);
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        WebElement dobInput = myInfoPage.inputs.get(11);
        Actions actions = new Actions(driver);
        actions.moveToElement(dobInput).perform();
        String dobActual = dobInput.getAttribute("value");
        Assert.assertEquals(dobActual.length(), 10);
        Allure.description("Date of Birth field is filled in");
    }

    @Test(priority = 3, description = "User can update the Date of Birth to any date")
    public void updateUserInfo() throws InterruptedException {
        Thread.sleep(3000);
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        WebElement dobInput = myInfoPage.inputs.get(11);
        Actions actions = new Actions(driver);
        actions.moveToElement(dobInput).click().perform();
        dobInput.sendKeys(Keys.CONTROL + "a");
        dobInput.sendKeys(Keys.BACK_SPACE);
        String dobExpected = "1901-01-01";
        dobInput.sendKeys(dobExpected);
        dobInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String dobActual = dobInput.getAttribute("value");
        Assert.assertEquals(dobActual, dobExpected);
        Allure.description("User can update the Date of Birth to any date");
    }

    @AfterTest
    public void logout() {
        MyInfoPage myInfoPage = new MyInfoPage(driver);
        myInfoPage.btnProfileIcon.click();
        driver.findElement(By.partialLinkText("Logout")).click();
    }
}
