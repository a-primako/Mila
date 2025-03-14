package by.mila.ui;

import by.mila.ui.pages.LoginPage;
import by.mila.ui.utils.Singleton;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("UI Тесты")
@Feature("Авторизация")
public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeEach
    @Step("Открытие главной страницы и инициализация страницы логина")
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Негативный тест: Неверные учетные данные")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет попытку авторизации с некорректным логином и паролем")
    public void testLoginWithInvalidCredentials() {
        loginPage.clickLoginPageButton();
        loginPage.enterUsername("111111111");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorMessageDisplayed(), "Неверный логин или пароль.");
    }

    @Test
    @Story("Негативный тест: Пустые поля")
    @Severity(SeverityLevel.MINOR)
    @Description("Тест проверяет попытку авторизации с пустыми полями логина и пароля")
    public void testLoginWithEmptyFields() {
        loginPage.clickLoginPageButton();
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorMessageDisplayed(), "Неверный логин или пароль.");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Singleton.quitDriver();
    }
}
