package gui.lesson7;

import base.config.BaseTest;
import base.custom.Constants;
import base.pages.DetailItemPage;
import base.pages.Item;
import base.pages.LoginPage;
import base.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DetailItemTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    MainPage mainPage = new MainPage();

    DetailItemPage detailItemPage = new DetailItemPage();
    @Test
    public void detailTest(){
        loginPage.typePassword(Constants.PASSWORD);
        loginPage.typeUsername(Constants.USERNAME);
        loginPage.clickLoginButton();

        List<Item> itemsList = mainPage.getItemList();

        mainPage.clickItemHeadersByPosition(3);

        Item detailItem = detailItemPage.getDetailItem();

        Assert.assertTrue(itemsList.contains(detailItem), "Items list not contains that item");
    }
}
