package pages;

import base.BasePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class TrainingListPage extends BasePage {

    private SelenideElement trainingList = $(By.xpath("/html/body/div/header/div/div/nav/ul/li/a[@class=\"topNavItem training click hover\"]"));
    private SelenideElement skilsDropDown = $(By.xpath("//div[@ng-click=\"openSkillsDropDown()\"]"));
    private SelenideElement searchTrainingBySkill = $(By.xpath("//input[@ng-model=\"searchTrainingBySkills\"]"));
    private ElementsCollection checkSkills = $$(By.xpath("//label[@ng-class=\"{ 'drop-down__active-label': isSkillChecked(trainingItem) }\"]"));
    private SelenideElement searchTraining = $(By.xpath("//*[@class=\"section-ui__title ng-binding\" and text()=\"TRAININGS\"]"));
    private SelenideElement locationsDropDown = $(By.xpath("//div[@ng-click=\"openLocationsDropDown()\"]"));
    private SelenideElement searchTrainingByLocations = $(By.xpath("//input[@ng-model='searchTrainingByLocations']"));
    private SelenideElement checkmark = $(By.xpath("//input[@ng-click=\"checkLocationCountryNew(locations)\"]/following-sibling::span"));
    private SelenideElement clearLocations = $(By.xpath("//span[@ng-click=\"clearAllLocations()\"]"));
    private ElementsCollection searchCheck = $$(By.xpath("//div[@class=\"training-list__container training-list__desktop\"]//div[@class=\"training-item__location ng-binding\"]"));


    public TrainingListPage openTrainingList() {
        trainingList
                .waitUntil(Condition.visible, 10000)
                .click();
        return this;
    }

    public TrainingListPage scrollToSearchTraining() {
        searchTraining.scrollTo();
        return this;
    }

    public TrainingListPage doTrainingBySkills(String Text) {
        skilsDropDown.click();
        searchTrainingBySkill.val(Text);
        return this;
    }

    public TrainingListPage doTrainingByLocations(String Text) {
        locationsDropDown.click();
        searchTrainingByLocations.val(Text);
        locationsDropDown.click();
        return this;
    }

    public TrainingListPage choiseCheckmark() {
        checkmark.click();
        return this;
    }

    public TrainingListPage clearAllLocations() {
        clearLocations.click();
        return this;
    }

    public TrainingListPage validationOfSearch(String expectedText) {
        searchCheck.forEach(element -> assertTrue(element.getText().contains(expectedText)));
        return this;
    }

    public TrainingListPage checkSkillsInTrainingItem(int n) {
        checkSkills.shouldHave(CollectionCondition.size(n));
        return this;
    }
}
