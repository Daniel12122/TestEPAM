package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInTest extends BaseTest {

    @Test
    public void verifyLoginWithAppropriateCredentials() {
        HomePage
                .openHomePage()
                .openSignInModal()
                .doLoginWithUser("pazikovd@gmail.com", "19661311q")
                .verifyYourLogin();
    }

    @Test
    public void verifyLoginWithIncorrectCredentials() {
        HomePage
                .openHomePage()
                .openSignInModal()
                .doLoginWithUser("test@gmail.com", "testPassword");
        new LogInPage()
                .checkedErrorMessageIsDispleyd();
    }
}
