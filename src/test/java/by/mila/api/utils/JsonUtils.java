package by.mila.api.utils;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    public static JSONObject readJsonFromFile(String filePath) throws Exception {
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(jsonString);
    }

    public static boolean areJsonSimilar(JSONObject expected, JSONObject actual) {
        return actual.similar(expected);
    }
}