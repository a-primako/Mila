package by.mila.front;

import by.mila.front.testCred.SearchPage;
import by.mila.front.utils.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testSearchValidQuery() {
        searchPage.clickSearchField();
        searchPage.enterQuery("Помада-бальзам для губ BEAUTY BOMB");
        searchPage.clickSearchButton();
        assertTrue(searchPage.isSearchResultDisplayed(), "Помада-бальзам для губ BEAUTY BOMB, тон 02");
    }

    @Test
    public void testSearchInvalidQuery() {
        searchPage.clickSearchField();
        searchPage.enterQuery("Помада-бальзам для губ BEAUTY BOMB, тон 02");
        searchPage.clickSearchButton();
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "По вашему поисковому запросу ничего не найдено.");
    }

    @Test
    public void testSearchEmptyQuery() {
        searchPage.clickSearchField();
        searchPage.clickSearchButton();
        assertTrue(searchPage.isNoResultsMessageDisplayed(), "По вашему поисковому запросу ничего не найдено.");
    }

    @AfterEach
    public void tearDown() {
        Singleton.quitDriver();
    }
}
