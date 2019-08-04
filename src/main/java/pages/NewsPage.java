package pages;

import base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewsPage extends BasePage {

    private SelenideElement news = $(By.xpath("/html/body/div/header/div/div/nav/ul/li/a[@class=\"topNavItem news click hover\"]"));
    private ElementsCollection checkLinksAreDisplayed = $$(By.xpath("//div[@ng-click=\"changeNewsCategory(category.id)\"]"));

    public NewsPage openNews() {
        news
                .waitUntil(Condition.visible,10000)
                .click();
        return this;
    }

    public NewsPage verifyLinksAreDisplayed(int s) {
        checkLinksAreDisplayed
                .shouldHave(size(s));
        return this;
    }
}
