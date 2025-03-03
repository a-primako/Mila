package by.mila.front;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    // Локаторы элементов страницы
    private By searchField = By.xpath("//input[@class='search-inp']");
    private By searchButton = By.xpath("//button[@class='search-but']");
    private By searchResult = By.xpath("//span[@class='label offer-name']");
    private By noResultsMessage = By.xpath("//div[@class='catalog-list']");

    // Конструктор
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для взаимодействия с элементами страницы
    public void clickSearchField() {
        driver.findElement(searchField).click();
    }

    public void enterQuery(String query) {
        driver.findElement(searchField).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultDisplayed() {
        return driver.findElement(searchResult).isDisplayed();
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElement(noResultsMessage).isDisplayed();
    }
}
