package org.kevin.steps.web;

import org.kevin.pages.CartPage;
import org.kevin.pages.ProductsPage;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {

    private CartPage getCartPage() {
        return new CartPage(DriverManager.getDriver());
    }
    
    private ProductsPage getProductsPage() {
        return new ProductsPage(DriverManager.getDriver());
    }

    @Given("keranjang belanja kosong")
    public void keranjang_belanja_kosong() {
        assertEquals("0", getProductsPage().getCartBadgeCount());
    }

    @When("saya menambahkan produk ke-{int} ke dalam keranjang")
    public void saya_menambahkan_produk_ke_ke_dalam_keranjang(Integer index) {
        getProductsPage().clickAddToCartByIndex(index - 1);
    }

    @Then("angka pada badge keranjang harus {string}")
    public void angka_pada_badge_keranjang_harus(String expectedCount) {
        String actual = "";
        for (int i = 0; i < 5; i++) {
            actual = getProductsPage().getCartBadgeCount();
            if (expectedCount.equals(actual)) {
                break;
            }
            try { Thread.sleep(500); } catch (Exception e) {}
        }
        assertEquals(expectedCount, actual);
    }

    @When("saya menuju halaman keranjang")
    public void saya_menuju_halaman_keranjang() {
        getProductsPage().goToCart();
    }

    @When("saya menghapus produk pertama dari keranjang")
    public void saya_menghapus_produk_pertama_dari_keranjang() {
        getCartPage().clickRemoveFirstItem();
    }
}
