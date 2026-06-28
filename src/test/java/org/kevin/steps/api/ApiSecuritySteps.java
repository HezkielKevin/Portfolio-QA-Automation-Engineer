package org.kevin.steps.api;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;

public class ApiSecuritySteps {

    private Response response;
    private final String BASE_URL = "https://reqres.in/api";

    @When("saya mengirimkan request POST ke {string} dengan payload otentikasi rusak")
    public void saya_mengirimkan_request_post_ke_dengan_payload_otentikasi_rusak(String endpoint) {
        String payload = "{\"email\": \"eve.holt@reqres.in\"}"; // Missing password
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(BASE_URL + endpoint);
    }

    @When("saya mengirimkan request POST ke {string} dengan payload SQL Injection")
    public void saya_mengirimkan_request_post_ke_dengan_payload_sql_injection(String endpoint) {
        String payload = "{\"email\": \"eve.holt@reqres.in' OR 1=1 --\", \"password\": \"secret\"}";
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(BASE_URL + endpoint);
    }

    @Then("response API harus ditolak karena bad request atau unauthorized")
    public void response_api_harus_ditolak_karena_bad_request_atau_unauthorized() {
        int statusCode = response.getStatusCode();
        assertTrue(statusCode >= 400 && statusCode < 500, 
            "API seharusnya menolak request (4xx) tetapi mengembalikan status: " + statusCode);
    }
}
