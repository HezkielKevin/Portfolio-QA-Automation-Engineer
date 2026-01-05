package com.example.steps;

import com.example.pages.LoginPage;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private LoginPage getLoginPage() {
        return new LoginPage(DriverManager.getDriver());
    }

    @Given("saya membuka halaman login")
    public void saya_membuka_halaman_login() {
        getLoginPage().open();
    }

    @When("saya memasukkan username {string}")
    public void saya_memasukkan_username(String username) {
        getLoginPage().enterUsername(username);
    }

    @When("saya memasukkan username yang sangat panjang")
    public void saya_memasukkan_username_yang_sangat_panjang() {
        getLoginPage().enterUsername("a".repeat(100));
    }

    @When("saya memasukkan password {string}")
    public void saya_memasukkan_password(String password) {
        getLoginPage().enterPassword(password);
    }

    @When("saya klik tombol login")
    public void saya_klik_tombol_login() {
        getLoginPage().clickLogin();
    }

    @Then("saya berhasil login dan melihat dashboard")
    public void saya_berhasil_login_dan_melihat_dashboard() {
        assertTrue(DriverManager.getDriver().getCurrentUrl().contains("inventory.html"),
                "Dashboard tidak muncul setelah login");
    }

    @Then("saya melihat pesan error {string}")
    public void saya_melihat_pesan_error(String expectedError) {
        assertEquals(expectedError.trim(), getLoginPage().getErrorMessage().trim());
    }
}