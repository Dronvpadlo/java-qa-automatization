package gui.lesson1;

import base.config.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest(){
        //Selenide.open("https://www.google.com");
        //$("asd").click();
        System.out.println("My first QA test");
    }
}
