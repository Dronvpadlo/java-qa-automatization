package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends PageTools {

    private final String appLogo = "//div[@class='app_logo']";

    private final String itemHeaders = "//div[@class='inventory_item_name ']";

    private final String itemDescription = "//div[@class='inventory_item_desc']";

    private final String itemPrice = "//div[@class='inventory_item_price']";

    private final String itemHeadersByPosition = "(//div[@class='inventory_item_name '])[%d]";

    private final String addToCartButton = "//button[text()='Add to cart']";

    private final String shoppingCardButton = "//a[@class='shopping_cart_link']";

    private final String burgerMenuButton = "react-burger-menu-btn";

    private final String burgerMenuItem = "//a[text()='%s']";

    public List<Item> getItemList(){
        List<Item> items = new ArrayList<>();

        List<String> headersList = getElementsTexts("xpath", itemHeaders);
        List<String> descriptionsList = getElementsTexts("xpath", itemDescription);
        List<String> pricesList = getElementsTexts("xpath", itemPrice);

            for (int i = 0; i < headersList.size(); i++) {
             Item item = new Item();

             item.setName(headersList.get(i));
             item.setDescription(descriptionsList.get(i));
             item.setPrice(pricesList.get(i));
             items.add(item);
        }
    return items;
    }







    public void waiterMainPageLogo(){
        $(byXpath(appLogo)).shouldBe(visible, Duration.ofSeconds(10));
    }

    public ElementsCollection getItemHeaders(){
        shouldCollection("xpath", CollectionCondition.size(6), itemHeaders);
        return getElements("xpath", itemHeaders);
    }

    public void clickItemHeadersByPosition(int position){
        shouldBe("xpath", clickable, itemHeadersByPosition, position);
        click("xpath", itemHeadersByPosition, position);
    }

    public List<String> getItemHeadersText(){
        shouldCollection("xpath", CollectionCondition.size(6), itemHeaders);
        return getElementsTexts("xpath", itemHeaders);
    }

    public void clickAddToCartButton(){
        $(byXpath(addToCartButton)).shouldBe(clickable).click();
    }

    public boolean isAppLogoVisible(){
        return isElementCondition("xpath", visible, appLogo);
    }

    public void clickShoppingCartButton(){
        $(byXpath(shoppingCardButton)).shouldBe(clickable).click();
    }

    public void clickBurgerMenuButton(){
        shouldBe("id", clickable, burgerMenuButton);
        click("id", burgerMenuButton);
    }

    public void clickBurgerMenuItem(String itemName){
        shouldBe("xpath", clickable, burgerMenuItem, itemName);
        click("xpath", burgerMenuItem, itemName);
    }
}
