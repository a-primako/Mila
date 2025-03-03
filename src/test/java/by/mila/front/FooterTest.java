package by.mila.front;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

    public class FooterTest {
        private static WebDriver driver;
        private static FooterPage footerPage;

        @BeforeEach
        public void setUp() {
            driver = Singleton.getDriver();
            driver.get("https://mila.by/");
            footerPage = new FooterPage(driver);
        }

        @Test
        public void testContactLink() {
            footerPage.clickContactLink();
            // Проверка перехода на страницу контактов (например, наличие заголовка страницы)
            assertTrue(footerPage.isResultForContactPage(), "Контакты");
        }

        @Test
        public void testFAQLink() {
            footerPage.clickFAQLink();;
            // Проверка перехода на страницу контактов (например, наличие заголовка страницы)
            assertTrue(footerPage.isResultForFAQPage(), "Вопрос-ответ");
        }

        @AfterEach
        public void tearDown() {
            Singleton.quit();
        }
    }

