package org.kevin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // Locators
    private By inventoryItems = By.className("inventory_item");
    private By itemNames = By.className("inventory_item_name");
    private By itemPrices = By.className("inventory_item_price");
    private By itemImages = By.cssSelector(".inventory_item_img img");
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartButtons = By.cssSelector(".btn_inventory");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryItems() {
        return driver.findElements(inventoryItems);
    }

    public List<WebElement> getItemNames() {
        return driver.findElements(itemNames);
    }

    public List<WebElement> getItemPrices() {
        return driver.findElements(itemPrices);
    }

    public List<WebElement> getItemImages() {
        return driver.findElements(itemImages);
    }

    public void selectSortOption(String visibleText) {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText(visibleText);
    }

    public String getFirstProductName() {
        return getItemNames().get(0).getText();
    }

    public void clickAddToCartByIndex(int index) {
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        List<WebElement> buttons = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".btn_inventory")));
        if (index < buttons.size()) {
            WebElement btn = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(buttons.get(index)));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            try { Thread.sleep(1000); } catch (Exception e) {}
        } else {
            throw new RuntimeException("Tombol Add to Cart tidak ditemukan pada index: " + index);
        }
    }

    public String getCartBadgeCount() {
        List<WebElement> badges = driver.findElements(cartBadge);
        if (badges.isEmpty()) {
            return "0";
        }
        return badges.get(0).getText();
    }

    public void goToCart() {
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement icon = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(cartIcon));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", icon);
        try { Thread.sleep(1000); } catch (Exception e) {}
    }
}
