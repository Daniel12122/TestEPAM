package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TrainingListPage;

public class TrainingListTest extends BaseTest {

    @Test
    public void verifyTrainingsSearchWorksProperlyWithSearchingInSkills() {
        HomePage
                .openHomePage()
                .openSignInModal()
                .doLoginWithUser("pazikovd@gmail.com", "19661311q");
        new TrainingListPage()
                .openTrainingList()
                .scrollToSearchTraining()
                .doTrainingBySkills("Java")
                .checkSkillsInTrainingItem(2)
                .doTrainingBySkills("DATA")
                .checkSkillsInTrainingItem(2)
                .doTrainingBySkills("Pascal")
                .checkSkillsInTrainingItem(0);
    }

    @Test
    public void verifyTrainingsSearchWorksProperlyWithSearchingInLocations() {
        HomePage
                .openHomePage()
                .openSignInModal()
                .doLoginWithUser("pazikovd@gmail.com", "19661311q");
        new TrainingListPage()
                .openTrainingList()
                .scrollToSearchTraining()
                .doTrainingByLocations("Kyiv")
                .choiseCheckmark()
                .validationOfSearch("Kyiv")
                .clearAllLocations()
                .doTrainingByLocations("LosAngeles");
    }
}
