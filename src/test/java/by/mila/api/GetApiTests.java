package by.mila.api;

import by.mila.api.utils.BaseApiTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.Test;

@Epic("API Тесты")
public class GetApiTests extends BaseApiTest {

    private static final String SEARCH_URL = "https://mila.by/search/";
    private static final String MAIN_PAGE_URL = "https://mila.by/";
    private static final String PRODUCT_CARD_URL = "https://mila.by/product/pomada-dlya-gub-stellary-sexy-rich-collection-ton-02-8808215-8808305/";
    private static final String CATALOG_URL = "https://mila.by/catalog/litso/";
    private static final String SEARCH_QUERY = "помада";

    @Test
    @Feature("Поиск товаров")
    @Story("Проверка поиска по ключевому слову")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет, что API поиска возвращает статус-код 200 при поиске ключевого слова 'помада'")
    public void testProductSearch() {
        setupBaseUrl(SEARCH_URL);

        Response response = sendGetRequest("q", SEARCH_QUERY);

        assertStatusCode(response, 200);
    }

    @Test
    @Feature("Главная страница")
    @Story("Доступность главной страницы")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что главная страница возвращает статус-код 200")
    public void mainPageTest() {
        setupBaseUrl(MAIN_PAGE_URL);

        Response response = sendGetRequest(null, null);

        assertStatusCode(response, 200);
    }

    @Test
    @Feature("Карточка товара")
    @Story("Доступность карточки конкретного товара")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что карточка товара возвращает статус-код 200")
    public void productCardTest() {
        setupBaseUrl(PRODUCT_CARD_URL);

        Response response = sendGetRequest(null, null);

        assertStatusCode(response, 200);
    }

    @Test
    @Feature("Каталог товаров")
    @Story("Доступность каталога")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что страница каталога возвращает статус-код 200")
    public void catalogTest() {
        setupBaseUrl(CATALOG_URL);

        Response response = sendGetRequest(null, null);

        assertStatusCode(response, 200);
    }
}
