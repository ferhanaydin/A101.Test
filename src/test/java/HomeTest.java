import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class HomeTest extends BaseTest{


    @Test
    public void giyimTest(){
        HomePage home = new HomePage(driver);
        home.cookieClose();
        home.giyimMenuClick();
        home.icgiyimClick();
        home.corapClick();
        home.findBlackCorap();
        String actualStr = home.testBlackCorap().getText();
        Assert.assertTrue(actualStr.contains("Siyah"), "Siyah Çorap Olduğu Doğrulandı");
        home.addToCart();
        home.gotoBasket();
        home.onayBasket();
        home.phoneSubmit();
        home.mailSubmit("denemmail@mail.com");
        home.createAddressClick();
        home.formSubmit();
        home.checkoutClick();
        String actualString = home.basketCheckout().getText();
        Assert.assertTrue(actualString.contains("Kart ile ödeme"), "Ödeme Sayfası Testi Başarılı");
    }


}
