package by.mila.ui;

import by.mila.ui.pages.MenuPage;
import by.mila.ui.utils.Singleton;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI Тесты")
@Feature("Меню сайта")
public class MenuTest {
    private static WebDriver driver;
    private static MenuPage menuPage;

    @BeforeEach
    @Step("Открытие главной страницы и инициализация страницы меню")
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        menuPage = new MenuPage(driver);
    }

    @Test
    @Story("Переход на страницу акций")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что кнопка 'Все акции и скидки' в меню работает корректно")
    public void testPromotionPage() {
        menuPage.clickPromotionButton();
        assertTrue(menuPage.isResultForPromotion(), "Все акции и скидки");
    }

    @Test
    @Story("Переход на страницу электронных сертификатов")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что кнопка 'Электронный подарочный сертификат' в меню работает корректно")
    public void testElectronicCertificatesPage() {
        menuPage.clickElectronicCertificatesButton();
        assertTrue(menuPage.isResultForElectronicCertificates(), "Электронный подарочный сертификат");
    }

    @Test
    @Story("Переход на страницу WOW-цен")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что кнопка 'WOW-цены' в меню работает корректно")
    public void testWowPricePage() {
        menuPage.clickWowPriceButton();
        assertTrue(menuPage.isResultForWowPriceButton(), "WOW-цены");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Singleton.quitDriver();
    }
}

