package gui.lesson3;

import base.config.BaseTest;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WorksWithElementsTest extends BaseTest {

    @Test
    public void worksWithElementsTest(){
        $(By.id("user-name")).append("standard_user");
        $(byAttribute("placeholder", "Password")).append("secret_sauce");
        //Selenide.actions().sendKeys($(byAttribute("placeholder", "Password")), Keys.BACK_SPACE).perform();
        //$(byValue("Login")).submit();
        Selenide.actions().sendKeys(Keys.ENTER).perform();

        $(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();

        ElementsCollection elements = $$(byXpath("//button[text()='Add to cart']"));
        while (elements.size() > 0){
            $(byXpath("//button[text()='Add to cart']")).click();
        }

        List<String> texts = $$(byXpath("//div[@class='inventory_item_name ']")).texts();
        System.out.println(texts);
        //$(byXpath("//button[text()='Add to cart']")).click();


        $(byXpath(" //a[text()='Twitter']")).click();
        Selenide.switchTo().window(1);
        Selenide.sleep(6000);
        $(byXpath("//nav[@role='navigation']")).click();
        Selenide.sleep(2000);
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        Selenide.sleep(2000);
        $(byXpath("//select[@class='product_sort_container']")).click();
        Selenide.sleep(4000);
        Selenide.actions().sendKeys(Keys.ESCAPE).perform();
    }


}
