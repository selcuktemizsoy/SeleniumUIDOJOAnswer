package com.epias.simple_tests.task_3;

import com.epias.simple_tests.Task_2.Driver;
import com.epias.simple_tests.Task_2.Utils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Hovers {

    public Hovers(){
        PageFactory.initElements(Driver.get(), this);
    }


    public void hoverOverImage(int number){
        WebElement element = Driver.get().findElement(By.xpath("(//div[@class='figure']//img)[" + number + "]"));
        Utils.hoverOver(element);
    }

    public void verifyNameIsVisible(int number){
        WebElement element = Driver.get().findElement(By.xpath("(//div[@class='figure']//h5)[" + number + "]"));
        Assertions.assertTrue(element.isDisplayed());
    }



}
