package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(className = "oxd-userdropdown-img")
    public WebElement imgProfile;
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> sideNavs;
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdowns;
    @FindBy(css = "[type=submit]")
    public WebElement btnSubmit;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
