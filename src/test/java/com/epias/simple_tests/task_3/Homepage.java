package com.epias.simple_tests.task_3;

import com.epias.simple_tests.Task_2.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickSubMenu(String subMenuLink){
        Driver.get().findElement(By.linkText(subMenuLink)).click();
    }


}
