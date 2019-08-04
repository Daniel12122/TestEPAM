package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;

public class NewsTest extends BaseTest {

   @Test
    public void verifyNewsPage() {
        HomePage
                .openHomePage()
                .openSignInModal()
                .doLoginWithUser("pazikovd@gmail.com", "19661311q");
        new NewsPage()
                .openNews()
                .verifyLinksAreDisplayed(4);
    }
}
