package base.pages;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FinishPage {

    private final String finishButton = "//button[@id='finish']";

    private final String completeHeader = "//h2[@class='complete-header']";

    private final String goHome = "//button[@id='back-to-products']";

    public void clickFinishButton(){
        $(byXpath(finishButton)).shouldBe(clickable).click();
    }

    public boolean isCompleteHeaderVisible(){
        return $(byXpath(completeHeader)).is(visible);
    }

    public void clickGoHome(){
        $(byXpath(goHome)).shouldBe(clickable).click();
    }
}
