package by.mila.front;

import by.mila.front.testCred.MenuPage;
import by.mila.front.utils.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {
    private static WebDriver driver;
    private static MenuPage menuPage;

    @BeforeEach
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        menuPage = new MenuPage(driver);
    }

    @Test
    public void testPromotionPage() {
        menuPage.clickPromotionButton();
        assertTrue(menuPage.isResultForPromotion(), "Все акции и скидки");
    }

    @Test
    public void testElectronicCertificatesPage() {
        menuPage.clickElectronicCertificatesButton();
        assertTrue(menuPage.isResultForElectronicCertificates(), "Электронный подарочный сертификат");
    }

    @Test
    public void testWowPricePage() {
        menuPage.clickWowPriceButton();
        assertTrue(menuPage.isResultForWowPriceButton(), "WOW-цены");
    }

    @AfterEach
    public void tearDown() {
        Singleton.quitDriver();
    }
}
