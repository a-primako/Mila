package by.mila.front;

import by.mila.front.testCred.FooterPage;
import by.mila.front.utils.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FooterTest {
    private static FooterPage footerPage;

    @BeforeEach
    public void setUp() {
        WebDriver driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        footerPage = new FooterPage(driver);
    }

    @Test
    public void testContactLink() {
        footerPage.clickContactLink();
        assertTrue(footerPage.isResultForContactPage(), "Контакты");
    }

    @Test
    public void testFAQLink() {
        footerPage.clickFAQLink();
        assertTrue(footerPage.isResultForFAQPage(), "Вопрос-ответ");
    }

    @AfterEach
    public void tearDown() {
        Singleton.quitDriver();
    }
}

