package by.mila.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseApiTest {
    protected static String baseUrl;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = baseUrl;
    }

    protected Response sendPostRequest(String url, String body) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(url);
    }

    protected void assertStatusCode(Response response, int expectedStatusCode) {
        assertEquals("Неверный статус-код ответа",
                expectedStatusCode,
                response.getStatusCode());
    }

    protected void assertJsonResponseMatchesExpected(Response response, String expectedResponsePath) throws Exception {
        JSONObject expected = JsonUtils.readJsonFromFile(expectedResponsePath);
        JSONObject actual = new JSONObject(response.getBody().asString());
        assertTrue("JSON структуры не совпадают", JsonUtils.areJsonSimilar(expected, actual));
    }
}