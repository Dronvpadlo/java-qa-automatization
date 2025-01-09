package base.pages;

import base.config.PageTools;

import static base.custom.CustomCondition.inputCondition;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageTools {

    private final String usernameInput = "//input[@placeholder='Username']";

    private final String getUsernameInputByPlaceholder = "//input[@placeholder='Username']";

    private final String passwordInput = "//input[@placeholder='Password']";

    private final String loginButton = "login-button";


    public void typeUsername(String username){
        shouldBe("xpath", inputCondition, usernameInput);
        type("xpath", username, usernameInput);
    }

    public void typeUsernameByPlaceholder(String username, String placeholderValue){
        shouldBe("xpath", inputCondition, getUsernameInputByPlaceholder, placeholderValue);
        type("xpath", username, getUsernameInputByPlaceholder, placeholderValue);
    }

    public void typePassword(String password){
        shouldBe("xpath", inputCondition, usernameInput);
        type("xpath", password, passwordInput);
    }

    public void clickLoginButton(){
        shouldBe("id", clickable, loginButton);
        click("id", loginButton);
    }
}
