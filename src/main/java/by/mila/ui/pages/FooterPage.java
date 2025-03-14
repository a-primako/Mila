package by.mila.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterPage {
    private WebDriver driver;

    private By footerContactLink = By.xpath("//a[text()='Контакты']");
    private By footerFAQLink = By.xpath("//a[text()='Вопрос-ответ']");
    private By cookieBanner = By.xpath("//div[@class='full-container cookie-wrapper']");
    private By cookieAcceptButton = By.xpath("//div[@class='button pink button-cookie']");
    private By resultForContactPage = By.xpath("//h1[text()='Контакты']");
    private By resultForFAQPage = By.xpath("//h1[text()='Вопрос-ответ']");

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactLink() {
        WebElement banner = driver.findElement(cookieBanner);
        if (banner.isDisplayed()) {
            WebElement acceptButton = banner.findElement(cookieAcceptButton);
            acceptButton.click();
        }
        driver.findElement(footerContactLink).click();
    }

    public void clickFAQLink() {
        WebElement banner = driver.findElement(cookieBanner);
        if (banner.isDisplayed()) {
            WebElement acceptButton = banner.findElement(cookieAcceptButton);
            acceptButton.click();
        }
        driver.findElement(footerFAQLink).click();
    }

    public boolean isResultForContactPage() {
        return driver.findElement(resultForContactPage).isDisplayed();
    }

    public boolean isResultForFAQPage() {
        return driver.findElement(resultForFAQPage).isDisplayed();
    }
}
