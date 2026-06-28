package org.kevin.steps.web;

import org.kevin.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSteps {

    private ProductsPage getProductsPage() {
        return new ProductsPage(DriverManager.getDriver());
    }

    @Then("saya melihat daftar produk tersedia")
    public void saya_melihat_daftar_produk_tersedia() {
        assertTrue(getProductsPage().getInventoryItems().size() > 0, "Daftar produk kosong");
    }

    @Then("semua produk memiliki nama dan harga")
    public void semua_produk_memiliki_nama_dan_harga() {
        List<WebElement> names = getProductsPage().getItemNames();
        List<WebElement> prices = getProductsPage().getItemPrices();
        
        assertEquals(names.size(), prices.size(), "Jumlah nama dan harga produk tidak sama");
        
        for(WebElement name : names) {
            assertFalse(name.getText().isEmpty(), "Ditemukan produk tanpa nama");
        }
        for(WebElement price : prices) {
            assertFalse(price.getText().isEmpty(), "Ditemukan produk tanpa harga");
        }
    }

    @Then("semua produk menampilkan gambar dengan benar")
    public void semua_produk_menampilkan_gambar_dengan_benar() {
        List<WebElement> images = getProductsPage().getItemImages();
        for(WebElement img : images) {
            String src = img.getAttribute("src");
            assertNotNull(src, "Atribut SRC gambar hilang");
            assertFalse(src.contains("WithGarbageOnItToBreakTheUrl"), "Ditemukan broken image (problem_user behaviour)");
        }
    }

    @When("saya memilih urutan produk berdasarkan {string}")
    public void saya_memilih_urutan_produk_berdasarkan(String sortType) {
        getProductsPage().selectSortOption(sortType);
    }

    @Then("produk pertama harus bernama {string}")
    public void produk_pertama_harus_bernama(String expectedName) {
        assertEquals(expectedName, getProductsPage().getFirstProductName());
    }
}
