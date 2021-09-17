package com.epias.simple_tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoTest {

    public static void main(String[] args) {
       demoDriver();
    }

    @Test
    public void demoTest(){
        demoDriver();
    }

    public static void demoDriver(){
        System.out.println("hello world");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com.tr");
        driver.get("https://kloia.com");
        driver.navigate().back();
        driver.quit();
    }


}
