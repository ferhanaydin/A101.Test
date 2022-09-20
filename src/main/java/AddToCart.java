import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class AddToCart {
    WebDriver driver;

    public AddToCart(WebDriver driver){
        this.driver = driver;
    }

    public void pageTest(){
        if (driver != null ){
            driver.getCurrentUrl();
        }else{
            System.out.println(driver);
        }
    }

    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
