package apiauto;

import io.restassured.response.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
    public static String readJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void validateStatusCode(Response response, int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }
}