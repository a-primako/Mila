package by.mila.front;

import by.mila.front.testCred.LoginPage;
import by.mila.front.utils.Singleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = Singleton.getDriver();
        driver.get("https://mila.by/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.clickLoginPageButton();
        loginPage.enterUsername("111111111");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorMessageDisplayed(), "Неверный логин или пароль.");
    }

    @Test
    public void testLoginWithEmptyFields() {
        loginPage.clickLoginPageButton();
        loginPage.clickLoginButton();
        assertTrue(loginPage.isErrorMessageDisplayed(), "Неверный логин или пароль.");
    }

    @AfterEach
    public void tearDown() {
        Singleton.quitDriver();
    }
}
