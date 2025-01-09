package base.custom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebElementCondition;

public class CustomCondition {

    public static WebElementCondition inputCondition = Condition.and("input condition", Condition.visible, Condition.empty);
}
