package base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    Random random = new Random();

    public void setDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.setExperimentalOption("profile.default_content_setting_values.notifications",2);
        driver = new ChromeDriver(chrome_options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public void navigate_to(String url){
        driver.get(url);
    }

    public WebElement wait_for_element(By selector){
        return wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public List<WebElement> wait_for_all_elements(By selector){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public void wait_for_element_disappears(By selector){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public boolean element_exists(By selector){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }

    public int random_number(int first_value, int second_value){
        return random.ints(first_value,second_value).findFirst().getAsInt();
    }

    public void tear_down(){
        driver.quit();
    }

}
