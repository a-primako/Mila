package by.mila.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Локаторы элементов страницы
    private By loginPageButton = By.xpath("//div[@class='login-item popup-open']");
    private By usernameField = By.xpath("//input[@name='USER_LOGIN']");
    private By passwordField = By.xpath("//input[@name='USER_PASSWORD']");
    private By loginButton = By.xpath("//button[@class='button pink']");
    private By errorMessage = By.xpath("//div[@class='error auth-er']");

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия с элементами страницы
    public void clickLoginPageButton() {
        driver.findElement(loginPageButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
