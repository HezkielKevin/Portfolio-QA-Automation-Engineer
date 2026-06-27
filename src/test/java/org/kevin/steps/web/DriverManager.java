package org.kevin.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;

    @Before("@web")
    public void setUp() {
        // Menggunakan WebDriverManager untuk secara otomatis mengunduh ChromeDriver
        // yang sesuai dengan versi browser Chrome yang terinstal di sistem / CI
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    @After("@web")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
