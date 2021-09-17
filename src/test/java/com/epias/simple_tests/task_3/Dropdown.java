package com.epias.simple_tests.task_3;

import com.epias.simple_tests.Task_2.Driver;
import com.epias.simple_tests.Task_2.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    public Dropdown() {
        PageFactory.initElements(Driver.get(), this);
    }


    public void selectFromDropdownByText(String text){
        WebElement dropdown = Driver.get().findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }


}
