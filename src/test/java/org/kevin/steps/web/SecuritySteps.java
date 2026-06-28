package org.kevin.steps.web;

import org.kevin.pages.LoginPage;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class SecuritySteps {

    private LoginPage getLoginPage() {
        return new LoginPage(DriverManager.getDriver());
    }

    @Given("saya mencoba mengakses halaman inventory secara langsung")
    public void saya_mencoba_mengakses_halaman_inventory_secara_langsung() {
        DriverManager.getDriver().get("https://www.saucedemo.com/inventory.html");
    }

    @Then("saya harus dialihkan kembali ke halaman login dengan pesan error {string}")
    public void saya_harus_dialihkan_kembali_ke_halaman_login_dengan_pesan_error(String expectedError) {
        assertTrue(DriverManager.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/") 
                || DriverManager.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/index.html"),
                "User tidak dialihkan ke halaman login");
        assertEquals(expectedError.trim(), getLoginPage().getErrorMessage().trim());
    }
}
