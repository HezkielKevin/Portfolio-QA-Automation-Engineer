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
        String linuxPath = "/usr/local/bin/chromedriver";
        String windowsPath = "chromedriver.exe";

        // Cek path Linux dulu (prioritas CI)
        java.io.File driverFile = new java.io.File(linuxPath);
        if (driverFile.exists() && driverFile.canExecute()) {
            System.setProperty("webdriver.chrome.driver", linuxPath);
            System.out.println("Menggunakan ChromeDriver dari CI/Linux: " + linuxPath);
        } else {
            // Kalau nggak ada di Linux, coba Windows/local
            driverFile = new java.io.File(windowsPath);
            if (driverFile.exists() && driverFile.canExecute()) {
                System.setProperty("webdriver.chrome.driver", windowsPath);
                System.out.println("Menggunakan ChromeDriver lokal/Windows: " + windowsPath);
            } else {
                // fallback ke WebDriverManager kalau keduanya nggak ada
                 io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                 System.out.println("Fallback ke WebDriverManager auto-download");
            }
        }

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
