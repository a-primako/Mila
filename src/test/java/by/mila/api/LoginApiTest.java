package by.mila.api;

import by.mila.api.utils.BaseApiTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

@Epic("API Тесты")
@Feature("Авторизация")
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
    @Story("Негативный тест: неверный логин")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет, что попытка авторизации с неверным логином возвращает правильный ответ")
    public void testLoginNegativeLogin() throws Exception {
        SoftAssertions softly = initializeSoftAssertions();

        JSONObject requestBody = createRequestBody(TEST_NEG_LOGIN, TEST_POSIT_PASSWORD);

        Response response = sendRequest(requestBody);

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода")
                .isEqualTo(200);

        softly.assertThatCode(() -> assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_NEGATIVE_PATH))
                .as("Проверка JSON ответа")
                .doesNotThrowAnyException();

        softly.assertAll();
    }

    @Test
    @Story("Негативный тест: неверный пароль")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет, что попытка авторизации с неверным паролем возвращает правильный ответ")
    public void testLoginNegativePassword() throws Exception {
        SoftAssertions softly = initializeSoftAssertions();

        JSONObject requestBody = createRequestBody(TEST_POSIT_LOGIN, TEST_NEG_PASSWORD);

        Response response = sendRequest(requestBody);

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода")
                .isEqualTo(200);

        softly.assertThatCode(() -> assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_NEGATIVE_PATH))
                .as("Проверка JSON ответа")
                .doesNotThrowAnyException();

        softly.assertAll();
    }

    @Test
    @Story("Негативный тест: пустые учетные данные")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет, что попытка авторизации с пустым логином и паролем возвращает правильный ответ")
    public void testEmptyCredentials() throws Exception {
        SoftAssertions softly = initializeSoftAssertions();

        JSONObject requestBody = createRequestBody(EMPTY_LOGIN, EMPTY_PASSWORD);

        Response response = sendRequest(requestBody);

        softly.assertThat(response.getStatusCode())
                .as("Проверка статус-кода")
                .isEqualTo(200);

        softly.assertThatCode(() -> assertJsonResponseMatchesExpected(response, EXPECTED_RESPONSE_EMPTY_PATH))
                .as("Проверка JSON ответа")
                .doesNotThrowAnyException();

        softly.assertAll();
    }
}
