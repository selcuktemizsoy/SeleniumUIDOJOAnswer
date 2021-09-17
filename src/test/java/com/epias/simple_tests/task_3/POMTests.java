package com.epias.simple_tests.task_3;

import com.epias.simple_tests.Task_2.ConfigReader;
import com.epias.simple_tests.Task_2.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class POMTests {

    @BeforeEach
    public void setup(){
        String url = ConfigReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
    }

    @AfterEach
    public void teardown(){
        Driver.close();
    }

    @Test
    public void withoutPomTest(){
        WebElement element = Driver.get().findElement(By.linkText("Large & Deep DOM"));
        element.click();
        String text = Driver.get().findElement(By.tagName("h3")).getText();
        Assertions.assertEquals("Large & Deep DOM", text);
    }


    @Test
    public void pomTest2(){
        Homepage homepage = new Homepage();
        Hovers hovers = new Hovers();

        homepage.clickSubMenu("Hovers");
        hovers.hoverOverImage(1);
        hovers.verifyNameIsVisible(1);
        hovers.hoverOverImage(2);
        hovers.verifyNameIsVisible(2);
        hovers.hoverOverImage(3);
        hovers.verifyNameIsVisible(3);
    }

    @Test
    public void dropdownTest(){
        Homepage homepage = new Homepage();
        Dropdown dropdown = new Dropdown();

        homepage.clickSubMenu("Dropdown");
        dropdown.selectFromDropdownByText("Option 2");

    }

    @Test
    public void pomTest(){
        Homepage homepage = new Homepage();
        LargePage largePage = new LargePage();


        homepage.clickSubMenu("Large & Deep DOM");
        largePage.verifyTitle();
    }
}
