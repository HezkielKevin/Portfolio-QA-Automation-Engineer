package org.kevin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By cartItems = By.className("cart_item");
    private By removeButtons = By.xpath("//button[text()='Remove']");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(cartItems);
    }

    public void clickRemoveFirstItem() {
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        List<WebElement> buttons = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy(removeButtons));
        if(!buttons.isEmpty()) {
            WebElement btn = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(buttons.get(0)));
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }

    public void clickCheckout() {
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement btn = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(checkoutButton));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        try {
            Thread.sleep(1000); // Wait for Checkout page React component to fully hydrate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
