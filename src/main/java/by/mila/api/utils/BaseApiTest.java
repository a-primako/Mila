package by.mila.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;


public class BaseApiTest {
    protected static String baseUrl;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = baseUrl;
    }

    protected Response sendPostRequest(String url, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(url);
    }

    protected JSONObject createRequestBody(String login, String password) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", login);
        requestBody.put("pass", password);
        return requestBody;
    }

    protected Response sendRequest(JSONObject requestBody) {
        return sendPostRequest(baseUrl, requestBody.toString());
    }

    protected SoftAssertions initializeSoftAssertions() {
        return new SoftAssertions();
    }

    protected void assertStatusCode(Response response, int expectedStatusCode) {
        initializeSoftAssertions()
                .assertThat(response.statusCode())
                .as("Неверный статус-код ответа")
                .isEqualTo(expectedStatusCode);
    }

    protected void setupBaseUrl(String url) {
        baseUrl = url;
        BaseApiTest.setUp();
    }

    protected Response sendGetRequest(String paramName, String paramValue) {
        if (paramName != null && paramValue != null) {
            return given().queryParam(paramName, paramValue).when().get();
        }
        return given().when().get();
    }


    protected void assertJsonResponseMatchesExpected(Response response, String expectedResponsePath) throws Exception {
        JSONObject expected = JsonUtils.readJsonFromFile(expectedResponsePath);
        JSONObject actual = new JSONObject(response.getBody().asString());
        initializeSoftAssertions()
                .assertThat(actual.toString())
                .as("JSON структуры не совпадают")
                .isEqualTo(expected.toString());
    }
}