package com.epias.simple_tests.task_3;

import com.epias.simple_tests.Task_2.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LargePage {
    public LargePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(tagName = "h3")
    public WebElement title;


    public void verifyTitle(){
        Assertions.assertEquals("Large & Deep DOM", title.getText());
    }
}
