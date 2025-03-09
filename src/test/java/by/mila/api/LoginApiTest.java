package by.mila.api;

import by.mila.api.utils.BaseApiTest;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginApiTest extends BaseApiTest {
    private static final String BASE_URL = "https://mila.by/local/gtools/login/";
    private static final String EXPECTED_RESPONSE_NEGATIVE_PATH = "src/test/resources/loginNegativeResponce.json";
    private static final String EXPECTED_RESPONSE_EMPTY_PATH = "src/test/resources/loginNullResponce.json";

    private static final String EMPTY_LOGIN = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String TEST_NEG_LOGIN = "+375(29)302-46-12";
    private static final String TEST_NEG_PASSWORD = "TestPython";
    private static final String TEST_POSIT_LOGIN = "+375(29)302-46-11";
    private static final String TEST_POSIT_PASSWORD = "TestJava";

    @BeforeClass
    public static void setUp() {
        baseUrl = BASE_URL;
        BaseApiTest.setUp();
    }

    @Test
    public void testLoginNegativeLogin() throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", TEST_NEG_LOGIN);
        requestBody.put("pass", TEST_POSIT_PASSWORD);

        Response response = sendPostRequest(baseUrl, requestBody.toString());

        assertStatusCode(response, 200);
        assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_NEGATIVE_PATH);
    }

    @Test
    public void testLoginNegativePassword() throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", TEST_POSIT_LOGIN);
        requestBody.put("pass", TEST_NEG_PASSWORD);

        Response response = sendPostRequest(baseUrl, requestBody.toString());

        assertStatusCode(response, 200);
        assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_NEGATIVE_PATH);
    }

    @Test
    public void testEmptyCredentials() throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", EMPTY_LOGIN);
        requestBody.put("pass", EMPTY_PASSWORD);

        Response response = sendPostRequest(baseUrl, requestBody.toString());

        assertStatusCode(response, 200);
        assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_EMPTY_PATH);
    }
}
