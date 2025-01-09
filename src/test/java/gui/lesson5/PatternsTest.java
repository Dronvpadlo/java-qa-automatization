package gui.lesson5;

import base.config.BaseTest;
import base.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static base.custom.Constants.PASSWORD;
import static base.custom.Constants.USERNAME;

public class PatternsTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    MainPage mainPage = new MainPage();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    RegisterPage registerPage = new RegisterPage();

    FinishPage finishPage = new FinishPage();
    @Test
    public void patternTest(){
        loginPage.typeUsername(USERNAME);
        loginPage.typePassword(PASSWORD);
        loginPage.clickLoginButton();
        String firstItemText = mainPage.getItemHeadersText().get(0);

        mainPage.clickAddToCartButton();
        mainPage.clickShoppingCartButton();

        String firstCartText = shoppingCartPage.getItemNamesText().get(0);

        Assert.assertEquals(firstCartText, firstItemText, "texts is not equal");

        shoppingCartPage.clickCheckoutButton();

        registerPage.addTextToInputs();
        registerPage.clickContinueButton();

        finishPage.clickFinishButton();

        Assert.assertTrue(finishPage.isCompleteHeaderVisible(), "Complete Header is not visible");

        finishPage.clickGoHome();

    }
}
