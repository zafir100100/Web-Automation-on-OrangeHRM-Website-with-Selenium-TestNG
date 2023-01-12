package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Utils {
    private String firstName;
    private String lastName;

    public static void doScroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static int generateRandomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min) + min);
    }

    public static void waitForElement(WebDriver driver, WebElement element, int TIME_UNIT_SECONDS) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_UNIT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List readJSONArray(String fileName) throws IOException, ParseException {
        // note: this json file can't be blank initially
        // put {} or [] in file first, or it will generate
        // parse error
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) object;
        return jsonArray;
    }

    public void generateRandomData() {
        Faker faker = new Faker();
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void saveJsonList(String userName, String password) throws IOException, ParseException {
        // note: this json file can't be blank initially
        // put {} or [] in file first, or it will generate
        // parse error
        String fileName = "./src/test/resources/Users.json";
        java.io.FileReader reader = new java.io.FileReader(fileName);
        org.json.simple.parser.JSONParser parser = new JSONParser();

        Object obj = parser.parse(reader);
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject userObject = new JSONObject();
        userObject.put("userName", userName);
        userObject.put("password", password);
        jsonArray.add(userObject);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

        parser.reset();
        reader.close();
    }
}
