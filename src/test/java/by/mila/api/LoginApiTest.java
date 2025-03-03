package by.mila.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.*;

public class LoginApiTest {
    private static final String BASE_URL = "https://mila.by/local/gtools/login/";
    private static final String EXPECTED_RESPONSE_PATH = "src/test/resources/expectedResponseLogin.json";

    // Тестовые данные
    private static final String TEST_LOGIN = "+375(29)302-46-12";
    private static final String TEST_PASSWORD = "TestJava";

    @Test
    public void testLoginApiSuccess() throws Exception {
        // 1. Формирование запроса
        JSONObject requestBody = new JSONObject();
        requestBody.put("login", TEST_LOGIN);
        requestBody.put("pass", TEST_PASSWORD);

        // 2. Отправка запроса
        Response response = sendPostRequest(BASE_URL, requestBody.toString());

        // 3. Проверки
        assertStatusCode(response, 200);
        assertJsonResponseMatchesExpected(response);
    }

    private Response sendPostRequest(String url, String body) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(url);
    }

    private void assertStatusCode(Response response, int expectedStatusCode) {
        assertEquals("Неверный статус-код ответа",
                expectedStatusCode,
                response.getStatusCode());
    }

    private void assertJsonResponseMatchesExpected(Response response) throws Exception {
        // Чтение ожидаемого ответа
        String expectedJson = new String(Files.readAllBytes(Paths.get(EXPECTED_RESPONSE_PATH)));
        JSONObject expected = new JSONObject(expectedJson);

        // Парсинг актуального ответа
        JSONObject actual = new JSONObject(response.getBody().asString());

        // Сравнение JSON объектов
        assertTrue("JSON структуры не совпадают",
                actual.similar(expected));
    }
}