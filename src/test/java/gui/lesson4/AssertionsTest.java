package gui.lesson4;

import base.config.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebElementCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AssertionsTest extends BaseTest {

    @Test
    public void assertionsTest(){
        WebElementCondition inputCondition = and("inputCondition", visible, empty);

        $(byXpath("//input[@placeholder='Username']")).shouldBe(inputCondition, Duration.ofSeconds(5)).append("standard_user");
        $(byXpath("//input[@placeholder='Password']")).shouldBe(inputCondition).append("secret_sauce");
//        System.out.println("Hidden before: " + $(byXpath("//h3[@data-test='error']")).is(hidden));
//        System.out.println("Exist before: " + $(byXpath("//h3[@data-test='error']")).is(exist));
        $(byId("login-button")).shouldBe(clickable).click();
//        System.out.println("Hidden after: " + $(byXpath("//h3[@data-test='error']")).is(hidden));
//        System.out.println("Exist after: " + $(byXpath("//h3[@data-test='error']")).is(exist));
//        System.out.println($(byClassName("login_logo")).shouldBe(exist).shouldHave(text("swag")).getText());
//        System.out.println($(byXpath("//div[@class='app_logo']")).shouldBe(visible).text());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.size(6)).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts(List.of("Sauce Labs Back", "Sauce Labs Bik", "Sauce Labs Bolt T-", "Sauce Labs Fleece Ja", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.textsInAnyOrder(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Test.allTheThings() T-Shirt (Red)",  "Sauce Labs Onesie"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTexts(List.of("Sauce Labs Backpack", "Sauce labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTextsCaseSensitive(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());

        Assert.assertEquals($(byXpath("//div[@class='app_logo']")).getText(), "Swag Labs", "App logo not Equal");
        boolean appLogoVisible = $(byXpath("//div[@class='app_logo']")).is(visible);
        Assert.assertTrue(appLogoVisible, "Logo is visible");

        ElementsCollection itemCollection = $$(byXpath("//div[@class='inventory_item_name ']"));

        Assert.assertFalse(itemCollection.isEmpty(), "collection is empty");

        Assert.assertEquals(itemCollection.size(), 6, "collection size is not 6");

        List<String> itemsTitles = List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");

        Assert.assertEquals(itemCollection.texts(), itemsTitles, "Titles is not equald");

        Assert.assertTrue(itemCollection.texts().contains("Sauce Labs Bolt T-Shirt"), "There are not exist this title");
    }

}
