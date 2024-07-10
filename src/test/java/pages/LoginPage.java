package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

/**
 * Page class for the login page handling the login process using provided WebDriver.
 */
public class LoginPage {

    private WebDriver driver;  // Class level field to store WebDriver instance

    @FindBy(name = "username")
    public WebElement txtUserName;  // WebElement for the username input field

    @FindBy(css = "[type=password]")
    public WebElement txtPassword;  // WebElement for the password input field

    @FindBy(css = "[type=submit]")
    public WebElement btnSubmit;    // WebElement for the submit button

    @FindBy(className = "oxd-alert-content-text")
    public WebElement invalidCred;  // WebElement for the element displaying login errors

    /**
     * Constructor to initialize the PageFactory elements.
     *
     * @param driver The WebDriver instance that will be used to find the elements.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;  // Store the WebDriver instance for future use
        PageFactory.initElements(driver, this);  // Initialize WebElements with annotations
    }

    /**
     * Performs login using the provided username and password.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void doLogin(String username, String password) {
        txtUserName.clear();
        txtUserName.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
}
