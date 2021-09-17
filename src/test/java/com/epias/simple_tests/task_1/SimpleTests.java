package com.epias.simple_tests.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SimpleTests {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
    @Test
    public void titleTest(){
        driver.findElement(By.linkText("A/B Testing")).click();
        String text = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("A/B Test Variation 1", text);
    }

    @Test
    public void loginTest(){
        driver.findElement(By.partialLinkText("Form")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Secure Area", text);
    }
    @Test
    public void logoutTest(){
        driver.findElement(By.partialLinkText("Form")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Secure Area", text);
        driver.findElement(By.linkText("Logout")).click();
        String logoutText = driver.findElement(By.id("flash")).getText();
        Assertions.assertEquals("You logged out of the secure area!\n" +
                "×", logoutText);
    }

    @Test
    public void loadTestWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2:")).click();
        driver.findElement(By.cssSelector("#start>button")).click();
        String text = driver.findElement(By.cssSelector("#finish>h4")).getText();
        Assertions.assertEquals("Hello World!", text);

    }


    @Test
    public void loadTest(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1:")).click();
        driver.findElement(By.cssSelector("#start>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        String text = driver.findElement(By.cssSelector("#finish>h4")).getText();
        Assertions.assertEquals("Hello World!", text);
    }



}