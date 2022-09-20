import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    By giyimLocator = new By.ByCssSelector("li[data-pk='37a6c1c8-a180-4b87-9ec9-3a29f6453a0c']");
    By cookieLocator = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    By icgiyimLocator = new By.ByCssSelector("a[data-value='1565']");
    By corapLocator = new By.ByCssSelector("a[data-value='1567']");
    By blackLocator = new By.ByCssSelector("li[class='col-md-4 col-sm-6 col-xs-6 set-product-item']");
    By addToCartButton = new By.ByCssSelector("button[class='add-to-basket button green block with-icon js-add-basket']");
    By viewBasketLocator = new By.ByCssSelector("a[class='go-to-shop']");
    By onayBasketLocator = new By.ByCssSelector("a[class='button green checkout-button block js-checkout-button']");


    public void cookieClose(){
        waitFor(cookieLocator);
        driver.findElement(cookieLocator).click();
    }

    public void giyimMenuClick(){
        waitFor(giyimLocator);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(giyimLocator);
        action.moveToElement(element).perform();
        element.click();
    }

    public void icgiyimClick(){
        waitFor(icgiyimLocator);
        driver.findElement(icgiyimLocator).click();
    }

    public void corapClick(){
        waitFor(corapLocator);
        driver.findElement(corapLocator).click();
    }
    By corapSayfasiLocator = new By.ByCssSelector("div[class='total-product-count hidden-xs']");
    public void findBlackCorap(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return d.findElement(new By.ByCssSelector("div[class='total-product-count hidden-xs']")).getText().contains("Dizaltı Çorap");
            }
        });
        WebElement corapSayfasi = driver.findElement(corapSayfasiLocator);
        //driver.navigate().to(driver.getCurrentUrl());
        //Assert.isTrue(corapSayfasi.getText().contains("specific text"));

        if (corapSayfasi.getText().contains("Dizaltı Çorap")){
            List<WebElement> corapListesi = driver.findElements(blackLocator);
            for (WebElement corap: corapListesi
            ) { if (corap.getText().contains("Siyah")){
                corap.click(); break;
            }

            }
        }
    }
    By testCorapSayfasiLocator = By.xpath("//h1[@class='product-name js-name']");
    public WebElement testBlackCorap(){
        waitFor(testCorapSayfasiLocator);
        return driver.findElement(testCorapSayfasiLocator);
    }
    public void addToCart(){
        waitFor(addToCartButton);
        driver.findElement(addToCartButton).click();
    }
    public void gotoBasket(){
        waitFor(viewBasketLocator);
        driver.findElement(viewBasketLocator).click();
    }
    public void onayBasket(){
        waitFor(onayBasketLocator);
        driver.findElement((onayBasketLocator)).click();
    }
    By phoneOnayLocator = new By.ByCssSelector("a[class='auth__form__proceed js-proceed-to-checkout-btn']");
    public void phoneSubmit(){
        waitFor(phoneOnayLocator);
        driver.findElement(phoneOnayLocator).click();
    }
    By mailLocator = new By.ByCssSelector("input[name='user_email']");
    By buttonMailLocator = new By.ByCssSelector("button[class='button block green']");
    public void mailSubmit(String mailAddress){
        waitFor(buttonMailLocator);
        driver.findElement(mailLocator).sendKeys(mailAddress);
        driver.findElement(buttonMailLocator).click();
    }
    By createAddressLocator = new By.ByCssSelector("a[class='new-address js-new-address']");
    public void createAddressClick(){
        waitFor(createAddressLocator);
        driver.findElement(createAddressLocator).click();
    }
    By inputTitleLocator = By.name("title");
    By inputNameLocator = By.name("first_name");
    By inputSurNameLocator = By.name("last_name");
    By inputPhoneLocator = By.name("phone_number");
    By inputPostCodeLocator = By.name("postcode");
    By selectCityLocator = By.xpath("//select[@name='city']/option[text()='ADANA']");
    By selectTownshipLocator = By.xpath("//select[@name='township']/option[text()='CEYHAN']");
    By textAreaLocator = By.name("line");
    By buttonLocator = new By.ByCssSelector("button[class='button green js-set-country js-prevent-emoji']");
    By selectDisctrictLocator = By.xpath("//select[@name='district']/option[text()='ADATEPE MAH']");
    public void formSubmit(){
        waitFor(buttonLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//select[@name='city']")));
        actions.click().build().perform();
        driver.findElement(selectCityLocator).click();
        driver.findElement(inputTitleLocator).sendKeys(randomCharacter(20, 1));
        driver.findElement(inputNameLocator).sendKeys(randomCharacter(10, 1));
        driver.findElement(selectTownshipLocator).click();
        actions.moveToElement(driver.findElement(By.xpath("//select[@name='township']")));
        actions.click().build().perform();
        driver.findElement(inputSurNameLocator).sendKeys(randomCharacter(10, 1));
        driver.findElement(inputPhoneLocator).sendKeys(randomCharacter(10, 0));
        driver.findElement(textAreaLocator).sendKeys(randomCharacter(100, 1));
        //driver.findElement(inputPostCodeLocator).sendKeys("13211");
        driver.findElement(selectDisctrictLocator).click();
        actions.moveToElement(driver.findElement(By.xpath("//select[@name='district']")));
        actions.click().build().perform();


        driver.findElement(buttonLocator).click();
        /*actions.moveToElement(driver.findElement(buttonLocator));
        actions.click().build().perform();
        WebElement button = driver.findElement(buttonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", button);*/
    }
    By kargoLocator = By.xpath("//input[@name='shipping' and @value='333']");
    By cartButtonLocator = new By.ByCssSelector("button[class='button block green js-proceed-button']");

    public void checkoutClick(){
        waitFor(cartButtonLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(kargoLocator));
        actions.click().build().perform();
        //driver.findElement(kargoLocator).click();
        /*WebElement radioBtn1 = driver.findElement(kargoLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);*/
        driver.findElement(cartButtonLocator).click();
    }

    By checkoutLocator = new By.ByCssSelector("div[class='checkout-payment js-tab-content active']");

    public WebElement basketCheckout(){
        waitFor(checkoutLocator);
        return driver.findElement(checkoutLocator);
        //System.out.println(driver.findElement(checkoutLocator).getText().contains("Kart ile ödeme"));

    }

    public void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String randomCharacter(int charLength, int charType){
        Random r = new Random();
        char[] randomBase = new char[charLength];

        String alphabet = " abcçdefghıijklmnoöprsştuüvyz ";
        String numbers = "123456789";
        for (int i = 0; i < charLength; i++) {
            //System.out.println(alphabet.charAt(r.nextInt(alphabet.length())));
            if (charType == 0){
                randomBase[i] = numbers.charAt(r.nextInt(numbers.length()));
            } else if (charType == 1) {
                randomBase[i] = alphabet.charAt(r.nextInt(alphabet.length()));
            }

        }
        String str = String.valueOf(randomBase);
        return str;
    }
}
