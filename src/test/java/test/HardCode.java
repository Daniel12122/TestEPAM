package test;

import base.BaseTest;
import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class HardCode extends BaseTest {

    private SelenideElement authSignInButton = $(By.xpath("//p[@ng-click=\"authSignIn()\"]"));
    private SelenideElement userNameInput = $(By.xpath("//input[@ng-model=\"authUser.Name\"]"));
    private SelenideElement userPasswordInput = $(By.xpath("//input[@ng-model=\"authUser.Password\"]"));
    private SelenideElement logInButton = $(By.xpath("//input[@value=\"Sign in\"]"));
    private SelenideElement openTrainingList =  $(By.xpath("/html/body/div/header/div/div/nav/ul/li/a[@class=\"topNavItem training click hover\"]"));
    private SelenideElement searchTrainingByLocations = $(By.xpath("//input[@ng-model='searchTrainingByLocations']"));
    private SelenideElement openLocationsDropDown = $(By.xpath("//div[@ng-click=\"openLocationsDropDown()\"]"));
    private SelenideElement checkmark = $(By.xpath("//input[@ng-click=\"checkLocationCountryNew(locations)\"]/following-sibling::span"));
    private SelenideElement clearAllLocations = $(By.xpath("//span[@ng-click=\"clearAllLocations()\"]"));
    private SelenideElement searchTrainingBySkills = $(By.xpath("//input[@ng-model=\"doTrainingBySkills\"]"));
    private SelenideElement openSkillsDropDown = $(By.xpath("//div[@ng-click=\"openSkillsDropDown()\"]"));
    private SelenideElement news = $(By.xpath("/html/body/div/header/div/div/nav/ul/li/a[@class=\"topNavItem news click hover\"]"));
    private SelenideElement training = $(By.xpath("/html/body/div/header/div/div/nav/ul/li/a[@class=\"topNavItem training click hover\"]"));
    private SelenideElement checkErrorMessage = $(By.xpath("//div[@class=\"popup__error-message ng-binding\"]"));
    private SelenideElement singOutButton = $(By.xpath("//div[@class=\"header-controls\"]/div/div/div/a[@href=\"/Auth/Logout\" and text()=\"Sign out\"]"));
    private SelenideElement userInfoArrow = $(By.xpath("//div[@class=\"user-info__photo\"]/following-sibling::div[@class=\"user-info__arrow\"]/div[@class=\"arrow\"]"));


    @BeforeClass
    public void setupClass() {
        Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger("org.apache.http");
        root.setLevel(ch.qos.logback.classic.Level.INFO);
        Configuration.startMaximized = true;
    }

    @Test
    public void verifyTrainingsSearchWorksProperlyWithSearchingInLocationsTask5() {
        open("https://www.training.by/");
        authSignInButton.click();
        userNameInput.val("pazikovd@gmail.com");
        userPasswordInput.val("19661311q");
        logInButton.click();
        openTrainingList.click();
        openLocationsDropDown.click();
        searchTrainingByLocations.val("Kyiv");
        checkmark.click();
        $$(By.xpath("//div[@class=\"training-list__container training-list__desktop\"]//div[@class=\"training-item__location ng-binding\"]"))
                .forEach(e->e.getText().contains("Kyiv"));
        openLocationsDropDown.click();
        $$(By.xpath("//div[@class=\"training-item__location ng-binding\" and text()=\"Kyiv, Ukraine\"]"));
        clearAllLocations.click();
        openLocationsDropDown.click();
        searchTrainingByLocations.val("Los Angeles");
    }

     @Test
      public void verifyNewsPageTask4() {
        open("https://www.training.by/");
        authSignInButton.click();
        userNameInput.val("pazikovd@gmail.com");
        userPasswordInput.val("19661311q");
        logInButton.click();
        news.click();
        $$(By.xpath("//div[@ng-click=\"changeNewsCategory(category.id)\"]")).shouldHave(size(4));

        sleep(3000);

    }

    @Test
    public void verifyTrainingsSearchWorksProperlyWithSearchingInSkillsTask3() {
        open("https://www.training.by/");
        authSignInButton.click();
        userNameInput.val("pazikovd@gmail.com");
        userPasswordInput.val("19661311q");
        logInButton.click();
        training.click();
        openSkillsDropDown.click();
        searchTrainingBySkills.val("Java");
        $$(By.xpath("//input[@ng-click=\"checkSkill(trainingItem)\"]")).shouldHave(size(2));
        searchTrainingBySkills.val("DATA");
        $$(By.xpath("//input[@ng-click=\"checkSkill(trainingItem)\"]")).shouldHave(size(2));
        searchTrainingBySkills.val("Pascal");
        $$(By.xpath("//input[@ng-click=\"checkSkill(trainingItem)\"]")).shouldHave(size(0));
    }

    @Test
    public void verifyLoginWithIncorrectCredentialsTask2() {
        open("https://www.training.by/");
        authSignInButton.click();
        userNameInput.val("username@gmail.com");
        userPasswordInput.val("password");
        logInButton.click();
        checkErrorMessage.find("Login failed. Please try again.");
    }

    @Test
    public void verifyLoginWithAppropriateCredentialsTask1() {
        open("https://www.training.by/");
        authSignInButton.click();
        userNameInput.val("pazikovd@gmail.com");
        userPasswordInput.val("19661311q");
        logInButton.click();
        userInfoArrow.click();
        if(singOutButton.isDisplayed()) {
            System.out.println("\n" + "You are logged in");
        } else {
            System.out.println("\n" + "You are not logged in");
        }
    }
}