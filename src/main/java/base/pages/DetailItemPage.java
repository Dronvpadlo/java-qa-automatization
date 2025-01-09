package base.pages;

import base.config.PageTools;

import static com.codeborne.selenide.Condition.visible;

public class DetailItemPage extends PageTools {

    private final String header = "//div[@class='inventory_details_name large_size']";

    private final String description = "//div[@class='inventory_details_desc large_size']";

    private final String price = "//div[@class='inventory_details_price']";


    public Item getDetailItem(){
        Item item = new Item();

        item.setName(getText("xpath", visible, header));
        item.setDescription(getText("xpath", visible, description));
        item.setPrice(getText("xpath", visible, price));

        return item;
    }
}
