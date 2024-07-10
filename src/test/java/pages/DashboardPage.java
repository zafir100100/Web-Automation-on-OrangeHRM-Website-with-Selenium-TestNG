package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    @FindBy(className = "oxd-userdropdown-img")
    public WebElement imgProfile;
    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> sideNavs;
    @FindBy(css = "[type=submit]")
    public WebElement btnSubmit;
    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement btnProfileIcon;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOsVersion(){
        Utils.doScrollDown(driver);
        WebElement element = driver.findElement(By.xpath("//p[contains(@class, 'orangehrm-copyright') and contains(normalize-space(), 'OS')]"));
        return element.getText();
    }
}
