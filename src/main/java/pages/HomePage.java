package pages;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    private SelenideElement buttonSingIn = $(By.xpath("//p[@ng-click=\"authSignIn()\"]"));
    private SelenideElement userName = $(By.xpath("//a[@class=\"user-info dropdown-toggle\"]/div[@class=\"user-info__name\"]"));

    public static HomePage openHomePage() {
        open("https://www.training.by/");
        return new HomePage();
    }
    public LogInPage openSignInModal() {
        buttonSingIn.click();
        return new LogInPage();
    }
    public HomePage verifyYourLogin() {
        userName
                .waitUntil(Condition.visible,10000);
        return this;
    }
}
