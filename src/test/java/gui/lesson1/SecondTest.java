package gui.lesson1;

import baseConfig.BaseTest;
import org.testng.annotations.*;

public class SecondTest extends BaseTest {


    @Test(priority = 2)
    public void secondTest(){
        System.out.println("My second QA Test");
    }

    @Test(groups = "vpadlo")
    public void thirdTest(){
        System.out.println("My third QA Test");
    }


}
