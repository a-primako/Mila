package by.mila.ui;

import by.mila.ui.pages.FooterPage;
import by.mila.ui.utils.Singleton;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI Тесты")
@Feature("Футер сайта")
public class FooterTest {
    private static FooterPage footerPage;

    @BeforeEach
    @Step("Открытие главной страницы")
    public void setUp() {
        WebDriver driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        footerPage = new FooterPage(driver);
    }

    @Test
    @Story("Проверка ссылки 'Контакты'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет работу ссылки 'Контакты' в футере сайта")
    public void testContactLink() {
        footerPage.clickContactLink();
        assertTrue(footerPage.isResultForContactPage(), "Контакты");
    }

    @Test
    @Story("Проверка ссылки 'Вопрос-ответ'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет работу ссылки 'Вопрос-ответ' в футере сайта")
    public void testFAQLink() {
        footerPage.clickFAQLink();
        assertTrue(footerPage.isResultForFAQPage(), "Вопрос-ответ");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Singleton.quitDriver();
    }
}
