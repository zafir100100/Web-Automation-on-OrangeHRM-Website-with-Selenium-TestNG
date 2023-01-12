package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeePage {
    @FindBy(className = "oxd-topbar-body-nav-tab")
    public List<WebElement> topNavs;
    @FindBy(className = "oxd-button")
    public List<WebElement> btnAddEmployee;
    @FindBy(css = "[type=submit]")
    public WebElement btnSubmit;
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdownBox;
    @FindBy(css = "[name=firstName]")
    WebElement txtFirstName;
    @FindBy(css = "[name=lastName]")
    WebElement txtLastName;
    @FindBy(className = "oxd-switch-input")
    public WebElement toggleButton;
    @FindBy(className = "oxd-input")
    public List<WebElement> txtUserCreds;
    @FindBy(className = "oxd-input-field-error-message")
    WebElement lblValidationError;
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> sideNavs;

    public EmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String checkIfUserExists(String userName) {
        txtUserCreds.get(0).sendKeys(userName);
        return lblValidationError.getText();
    }

    public void createEmployee(String firstName, String lastName, String userName, String password, String confirmPassword) throws InterruptedException {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        // sleep is must, because oxd-form-loader takes time to finish loading
        Thread.sleep(2000);
        txtUserCreds.get(5).sendKeys(userName);
        txtUserCreds.get(6).sendKeys(password);
        txtUserCreds.get(7).sendKeys(password);
        btnSubmit.click();
        // give some time to save data
        Thread.sleep(4000);
    }
}
