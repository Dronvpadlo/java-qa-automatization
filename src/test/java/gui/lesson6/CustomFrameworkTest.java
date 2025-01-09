package gui.lesson6;

import base.config.BaseTest;
import base.pages.LoginPage;
import base.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.custom.Constants.*;

public class CustomFrameworkTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void customTest(){
        loginPage.typePassword(PASSWORD);
        //loginPage.typeUsername(USERNAME);
        loginPage.typeUsernameByPlaceholder(USERNAME, "Username");
        loginPage.clickLoginButton();

        Assert.assertTrue(mainPage.isAppLogoVisible());
        //System.out.println(mainPage.getItemHeadersText());
        //mainPage.getItemHeaders().get(3).click();
        //mainPage.clickBurgerMenuButton();
        //mainPage.clickBurgerMenuItem("About");
        mainPage.clickItemHeadersByPosition(3);

    }
}
