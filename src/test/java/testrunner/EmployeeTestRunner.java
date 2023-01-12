package testrunner;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class EmployeeTestRunner extends Setup {
    @BeforeTest
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage = new LoginPage(driver);
        String adminUser = "admin";
        String adminPass = "admin123";
        loginPage.doLogin(adminUser, adminPass);
    }

    @Test(priority = 1, description = "Check if user exists")
    public void checkIfUserExists() throws IOException, ParseException, InterruptedException {
        // note: this is a negative test case
        DashboardPage dashboardPage = new DashboardPage(driver);
        // click on pim menu
        dashboardPage.sideNavs.get(1).click();
        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.btnAddEmployee.get(2).click();
        // sleep is must, because oxd-form-loader takes time to finish loading
        Thread.sleep(2000);
        employeePage.toggleButton.click();
        String fileName = "./src/test/resources/Users.json";
        List data = Utils.readJSONArray(fileName);
        JSONObject userObj = (JSONObject) data.get(data.size()-1);
        String existingUserName = (String) userObj.get("userName");
        employeePage.txtUserCreds.get(5).clear();
        employeePage.txtUserCreds.get(5).sendKeys("Admin");
        Thread.sleep(1000);
        String validationMessageActual = employeePage.checkIfUserExists(existingUserName);
        String validationMessageExpected = "Username already exists";

        Assert.assertTrue(validationMessageActual.contains(validationMessageExpected));
        employeePage.txtUserCreds.get(5).clear();
    }

    @Test(priority = 2, description = "Create new Employee")
    public void createEmployee() throws InterruptedException, IOException, ParseException {

        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.topNavs.get(2).click();
        Thread.sleep(2000);
        // click on top nav
        Utils utils = new Utils();
        utils.generateRandomData();
//        employeePage.topNavs.get(2).click();
        String firstName = utils.getFirstName();
        String lastName = utils.getLastName();
        int randomId = Utils.generateRandomNumber(1000, 9999);
        String userName = firstName + randomId;
        String password = "P@ssword123";
        employeePage.toggleButton.click();
        Thread.sleep(2000);
        employeePage.txtUserCreds.get(5).clear();
        employeePage.createEmployee(firstName, lastName, userName, password, password);

        List<WebElement> headerTitle = driver.findElements(By.className("orangehrm-main-title"));

        Utils.waitForElement(driver, headerTitle.get(0), 50);
        if (headerTitle.get(0).isDisplayed()) {
            utils.saveJsonList(userName, password);
        }

        Assert.assertTrue(headerTitle.get(0).isDisplayed());
    }
}
