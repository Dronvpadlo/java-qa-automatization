package base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TextReport.class})
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

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
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
