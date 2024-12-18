package baseConfig;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {

//    @BeforeGroups
//    public void beforeGroup(){
//        System.out.println("Before Group");
//    }

//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("Before Suite");
//    }

    @BeforeClass
    public void configuration(){
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 100000;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.pageLoadTimeout = 100000;
    }

    @BeforeMethod
    public void login(){
        Selenide.open("https://www.saucedemo.com/");
    }

//    @AfterMethod
//    public void cleanWebDriver(){
//        Selenide.clearBrowserCookies();
//        Selenide.refresh();
//        Selenide.open("about:blank");
//    }
//
//    @AfterClass
//    public void closeBrowser(){
//        Selenide.closeWebDriver();
//    }
//
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("After Suite");
//    }

//    @AfterGroups
//    public void afterGroup(){
//        System.out.println("After Group");
//    }

}
