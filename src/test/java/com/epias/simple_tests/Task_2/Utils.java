package com.epias.simple_tests.Task_2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {


    public static void waitForElementDisappear(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void scrollDown(int pixel){
        ((JavascriptExecutor) Driver.get()).executeScript("window.scrollBy(0," + pixel +")");
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static void verifyAttribute(WebElement element, String attribute, String expectedValue){
        Assertions.assertEquals(expectedValue, element.getAttribute(attribute));
    }
}
