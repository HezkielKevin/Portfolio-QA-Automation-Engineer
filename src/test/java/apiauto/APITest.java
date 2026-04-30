package apiauto;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.kevin.config.ApiConfig;
import org.kevin.models.UserResponse;
import apiauto.TestUtils;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.given;

public class APITest {

//    @Test
//    public void GetUserTest(){
//        RestAssured.baseURI = "https://reqres.in/";
//        given().header("x-api-key","reqres-free-v1")
//                .when().get("api/users?page=1")
//                .then()
//                .log().all()
//                .assertThat().statusCode(200)
//                .assertThat().body("page", Matchers.equalTo(1))
//                .assertThat().body("data.id", Matchers.hasSize(6));
//    }
//
//    @Test
//    public void createNewUserTest(){
//        RestAssured.baseURI = "https://reqres.in/";
//        String name = "jayjay";
//        String job = "director";
//        JSONObject jsob = new JSONObject();
//        jsob.put("name",name);
//        jsob.put("job", job);
//        given().log().all()
//                .header("Content-Type", "application/json")
//                .header("Accept","application/json")
//                .header("x-api-key","reqres-free-v1")
//                .body(jsob.toString())
//                .post("api/users")
//                .then()
//                .assertThat().statusCode(201)
//                .assertThat().body("name", Matchers.equalTo(name))
//                .assertThat().body("job", Matchers.equalTo(job))
//                .assertThat().body("$", Matchers.hasKey("id"))
//                .assertThat().body("$", Matchers.hasKey("createdAt"));
//    }

    @BeforeClass
    @Parameters({"baseUrl", "apiKey"})
    public void setup(String baseUrl, String apiKey) {
        RestAssured.baseURI = baseUrl;
        ApiConfig.API_KEY = apiKey;
    }

    // Test Positif: GET /users?page=1
    @Test
    public void testGetUsersPositive() {
        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .queryParam("page", 1)
                .when()
                .get("/api/users")
                .then()
//                .log().all()
                .statusCode(401)
                .body("error", Matchers.notNullValue())
                .extract().response();
        // Gunakan TestUtils untuk validasi status code
        TestUtils.validateStatusCode(response, 401);

    }

    // Test Negatif: Invalid Patch Data
    @Test
    public void testGetUsersInvalidPage() {
        int userId = 3;
        String newName = "J.Co We do dew";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Gender", "Female");
        JSONObject jsonObject = new JSONObject(hashMap);

        Response response = given()
                .header("x-api-key", ApiConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("/api/users/" + userId)
                .then().extract().response();
//                .log().all()
        // Gunakan TestUtils untuk validasi status code
        TestUtils.validateStatusCode(response, 401);
    }

    // Test Batas: Page melebihi total_pages
    @Test
    public void testGetUsersBeyondTotalPages() {
        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .queryParam("page", 999)
                .when()
                .get("/api/users")
                .then()
//                .log().all()
                .body("error", Matchers.notNullValue()) // Expect error
                .extract().response();
        TestUtils.validateStatusCode(response, 401);
    }

    // Test Positif: POST /users
    @Test
    public void testCreateUserPositive() throws IOException {
        String requestBody = TestUtils.readJsonFile("src/test/resources/testdata/create_user.json");

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
//                .log().all()
                .body("error", Matchers.notNullValue())
                .extract().response();
        TestUtils.validateStatusCode(response, 401);
    }

    // Test Negatif: POST tanpa Token
    @Test
    public void testCreateUserMissingToken() {
        String requestBody = "{\"name\": [\"J.Co we\"]}";
        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
//                .header("x-api-key", ApiConfig.API_KEY) Tanpa token
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
//                .log().all()
                .extract().response();
        TestUtils.validateStatusCode(response, 401);
    }
}
