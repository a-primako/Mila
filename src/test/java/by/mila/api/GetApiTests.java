package by.mila.api;

import by.mila.api.utils.BaseApiTest;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetApiTests extends BaseApiTest {
    private static final String SEARCH_URL = "https://mila.by/search/";
    private static final String MAIN_PAGE_URL = "https://mila.by/";
    private static final String PRODUCT_CARD_URL = "https://mila.by/product/pomada-dlya-gub-stellary-sexy-rich-collection-ton-02-8808215-8808305/";
    private static final String CATALOG_URL = "https://mila.by/catalog/litso/";

    private static final String SEARCH_QUERY = "помада";

    @Test
    public void testProductSearch() {
        baseUrl = SEARCH_URL;
        BaseApiTest.setUp();
        Response response = given().queryParam("q", SEARCH_QUERY).when().get();
        assertStatusCode(response, 200);
    }

    @Test
    public void mainPageTest() {
        baseUrl = MAIN_PAGE_URL;
        BaseApiTest.setUp();
        Response response = given().when().get();
        assertStatusCode(response, 200);
    }

    @Test
    public void productCardTest() {
        baseUrl = PRODUCT_CARD_URL;
        BaseApiTest.setUp();
        Response response = given().when().get();
        assertStatusCode(response, 200);
    }

    @Test
    public void catalogTest() {
        baseUrl = CATALOG_URL;
        BaseApiTest.setUp();
        Response response = given().when().get();
        assertStatusCode(response, 200);
    }
}
