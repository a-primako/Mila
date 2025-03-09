package by.mila.front.testCred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

    private WebDriver driver;

    private By promotionButton = By.xpath("//div[@class='dropdown-but block-link menu-id-first']");
    private By electronicCertificatesButton = By.xpath("//div[@class=' block-link menu-id-second']");
    private By wowPriceButton = By.xpath("//div[@class=' block-link menu-id-11610']");
    private By resultForPromotion = By.xpath("//h1[text()='Все акции и скидки']");
    private By resultForElectronicCertificates = By.xpath("//h1[text()='Электронный подарочный сертификат']");
    private By resultForWowPriceButton = By.xpath("//h1[text()='WOW-цены']");


    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickPromotionButton() {
        driver.findElement(promotionButton).click();
    }

    public void clickElectronicCertificatesButton() {
        driver.findElement(electronicCertificatesButton).click();
    }

    public void clickWowPriceButton() {
        driver.findElement(wowPriceButton).click();
    }

    public boolean isResultForPromotion() {
        return driver.findElement(resultForPromotion).isDisplayed();
    }

    public boolean isResultForElectronicCertificates() {
        return driver.findElement(resultForElectronicCertificates).isDisplayed();
    }

    public boolean isResultForWowPriceButton() {
        return driver.findElement(resultForWowPriceButton).isDisplayed();
    }
}
