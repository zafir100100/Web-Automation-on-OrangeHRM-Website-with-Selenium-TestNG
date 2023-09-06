package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyInfoPage {
    @FindBy(tagName = "input")
    public List<WebElement> inputs;

    @FindBy(className = "oxd-userdropdown-name")
    public WebElement btnProfileIcon;

    public MyInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
