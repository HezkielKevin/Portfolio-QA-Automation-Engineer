package com.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.kevin.config.ApiConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private Response response;

    @Given("saya mengatur base URL ke {string}")
    public void sayaMengaturBaseURLKe(String url) {
        RestAssured.baseURI = url;
        ApiConfig.API_KEY = "reqres-free-v1";
    }

    @When("saya melakukan GET request ke {string} dengan parameter page {int}")
    public void sayaMelakukanGETRequestKeDenganParameterPage(String path, int page) {
        response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .queryParam("page", page)
                .when()
                .get(path);
    }

    @When("saya melakukan PATCH request ke {string} dengan body:")
    public void sayaMelakukanPATCHRequestKeDenganBody(String path, String body) {
        response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(body)
                .patch(path);
    }

    @When("saya melakukan POST request ke {string} dengan body dari file {string}")
    public void sayaMelakukanPOSTRequestKeDenganBodyDariFile(String path, String filePath) throws IOException {
        String body = new String(Files.readAllBytes(Paths.get(filePath)));
        response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                .header("x-api-key", ApiConfig.API_KEY)
                .header("Content-Type", "application/json")
                .body(body)
                .post(path);
    }

    @When("saya melakukan POST request ke {string} dengan body:")
    public void sayaMelakukanPOSTRequestKeDenganBody(String path, String body) {
        response = given()
                .header("User-Agent", "PostmanRuntime/7.43.0")
                // Tanpa token
                .header("Content-Type", "application/json")
                .body(body)
                .post(path);
    }

    @Then("status code harus {int}")
    public void statusCodeHarus(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("response body harus memiliki {string}")
    public void responseBodyHarusMemiliki(String key) {
        response.then().body(key, Matchers.notNullValue());
    }
}
