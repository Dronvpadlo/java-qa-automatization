package base.pages;

import static base.custom.Constants.*;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    private final String inputFirstName = "//input[@placeholder='First Name']";

    private final String lastNameInput = "//input[@placeholder='Last Name']";

    private final String zipInput = "//input[@placeholder='Zip/Postal Code']";

    private final String continueButton = "//input[@id='continue']";

    public void addTextToInputs(){
        $(byXpath(inputFirstName)).shouldBe(visible).append(FIRSTNAME);
        $(byXpath(lastNameInput)).shouldBe(visible).append(LASTNAME);
        $(byXpath(zipInput)).shouldBe(visible).append(ZIP);
    }

    public void clickContinueButton(){
        $(byXpath(continueButton)).shouldBe(clickable).click();
    }
}
