package pages;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage extends BasePage {

    private  SelenideElement userNameInput = $(By.xpath("//input[@ng-model=\"authUser.Name\"]"));
    private  SelenideElement userPasswordInput = $(By.xpath("//input[@ng-model=\"authUser.Password\"]"));
    private  SelenideElement logInButton = $(By.xpath("//input[@value=\"Sign in\"]"));
    private  SelenideElement checkErrorMessage = $(By.xpath("//div[@class=\"popup__error-message ng-binding\"]"));

    public HomePage doLoginWithUser(String email, String password) {
        userNameInput
                .setValue(email);
        userPasswordInput.setValue(password);
        logInButton.click();
        logInButton.waitUntil(Condition.not(Condition.exist),10000);
        return new HomePage();
    }
    public  void checkedErrorMessageIsDispleyd() {
        if (checkErrorMessage.isDisplayed()) {
            System.out.println("\n" + "Login failed. Please try again.");
        }
    }
}
