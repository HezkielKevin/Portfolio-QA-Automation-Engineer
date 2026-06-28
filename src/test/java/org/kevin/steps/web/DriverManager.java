package org.kevin.steps.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class DriverManager {
    private static WebDriver driver;

    @AfterStep("@web")
    public void takeScreenshotAfterStep(Scenario scenario) {
        if (driver != null) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                
                ByteArrayInputStream bais = new ByteArrayInputStream(screenshot);
                BufferedImage image = ImageIO.read(bais);
                
                Graphics2D g2d = image.createGraphics();
                String timestamp = new SimpleDateFormat("dd MMM yyyy @ HH:mm:ss").format(new Date());
                Font font = new Font("Arial", Font.PLAIN, 14);
                g2d.setFont(font);
                
                FontMetrics metrics = g2d.getFontMetrics(font);
                int textWidth = metrics.stringWidth(timestamp);
                int textHeight = metrics.getHeight();
                
                int margin = 10;
                int x = image.getWidth() - textWidth - margin;
                int y = image.getHeight() - margin;
                
                // Draw semi-transparent background
                g2d.setColor(new Color(0, 0, 0, 150));
                g2d.fillRect(x - 4, y - metrics.getAscent() - 2, textWidth + 8, textHeight + 4);
                
                // Draw text
                g2d.setColor(Color.WHITE);
                g2d.drawString(timestamp, x, y);
                g2d.dispose();
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                byte[] watermarkedScreenshot = baos.toByteArray();
                
                scenario.attach(watermarkedScreenshot, "image/png", "Screenshot - " + scenario.getName());
            } catch (Exception e) {
                System.out.println("Gagal mengambil screenshot: " + e.getMessage());
            }
        }
    }

    @Before("@web")
    public void setUp() {
        // Menggunakan WebDriverManager untuk secara otomatis mengunduh ChromeDriver
        // yang sesuai dengan versi browser Chrome yang terinstal di sistem / CI
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
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
