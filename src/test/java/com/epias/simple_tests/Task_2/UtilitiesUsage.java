package com.epias.simple_tests.Task_2;

import com.epias.simple_tests.Task_2.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class UtilitiesUsage {
/*
start with only driver
then add config reader
 */
    @BeforeEach
    public void setup(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Driver.get().get("http://the-internet.herokuapp.com");
        String url = ConfigReader.get("url");
        Driver.get().get(url);


    }

    @AfterEach
    public void tearDown(){
        Driver.close();
    }

    @Test
    public void testUtils(){
        Driver.get().findElement(By.partialLinkText("A/B"));
    }

    @Test
    public void loadTest(){
        Driver.get().findElement(By.linkText("Dynamic Loading")).click();
        Driver.get().findElement(By.partialLinkText("Example 1")).click();
        Driver.get().findElement(By.cssSelector("#start>button")).click();
        Utils.waitForElementDisappear(Driver.get().findElement(By.id("loading")));
        String text = Driver.get().findElement(By.cssSelector("#finish>h4")).getText();
        Assertions.assertEquals("Hello World!", text);
    }

    @Test
    public void scroll(){
        Driver.get().findElement(By.linkText("Infinite Scroll")).click();
        while(true){
            Utils.scrollDown(2500);
            Utils.scrollDown(2500);
        }
    }

    @Test
    public void entryAd(){
        Driver.get().findElement(By.linkText("Entry Ad")).click();
        WebElement closeButton = Driver.get().findElement(By.cssSelector(".modal-footer>p"));
        Utils.waitForElementClickable(closeButton);
        closeButton.click();
        String text = Driver.get().findElement(By.cssSelector(".example>h3")).getText();
        Assertions.assertEquals("Entry Ad", text);
        System.out.println(text);
    }

}
