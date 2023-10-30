package seminars.fiveth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    @Test
    public void  seleniumTest() throws InterruptedException {
        WebDriver driver = null;
        String text = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("Selenium");
            element.submit();

            WebElement element1 = driver.findElement(By.tagName("cite"));
            text = element1.getText();

            TimeUnit.SECONDS.sleep(5);
        } finally {
            driver.quit();
        }
        Assertions.assertThat(text).isEqualTo("https://www.selenium.dev");
    }

    @Test
    public void loginSiteTest() throws InterruptedException {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com");
            WebElement nameElement = driver.findElement(By.id("user-name"));
            nameElement.sendKeys("standard_user");

            WebElement passElement = driver.findElement(By.id("password"));
            passElement.sendKeys("secret_sauce");
            passElement.submit();

            WebElement products = driver.findElement(By.className("title"));
            Assertions.assertThat(products.getText()).isEqualTo("Products");
            TimeUnit.SECONDS.sleep(5);
        } finally {
            driver.quit();
        }
    }
}
