package by.mila.ui;

import by.mila.ui.pages.SearchPage;
import by.mila.ui.utils.Singleton;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI Тесты")
@Feature("Поиск на сайте")
public class SearchTest {
    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeEach
    @Step("Открытие главной страницы и инициализация страницы поиска")
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        searchPage = new SearchPage(driver);
    }

    @Test
    @Story("Поиск по валидному запросу")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет поиск по корректному запросу с отображением результатов")
    public void testSearchValidQuery() {
        searchPage.clickSearchField();
        searchPage.enterQuery("Помада-бальзам для губ BEAUTY BOMB");
        searchPage.clickSearchButton();
        assertTrue(searchPage.isSearchResultDisplayed(), "Помада-бальзам для губ BEAUTY BOMB, тон 02");
    }

    @Test
    @Story("Поиск по невалидному запросу")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет поиск по некорректному запросу и отображение сообщения об отсутствии результатов")
    public void testSearchInvalidQuery() {
        searchPage.clickSearchField();
        searchPage.enterQuery("Помада-бальзам для губ BEAUTY BOMB, тон 02");
        searchPage.clickSearchButton();
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "По вашему поисковому запросу ничего не найдено.");
    }

    @Test
    @Story("Поиск с пустым запросом")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет поведение поиска при отсутствии введенного текста")
    public void testSearchEmptyQuery() {
        searchPage.clickSearchField();
        searchPage.clickSearchButton();
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "По вашему поисковому запросу ничего не найдено.");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Singleton.quitDriver();
    }
}
