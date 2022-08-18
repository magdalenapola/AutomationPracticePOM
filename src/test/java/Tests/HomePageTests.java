package Tests;

import AutomationPages.HomePage;
import BaseForTests.BaseForTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseForTests {

    HomePage homePage = new HomePage(driver);

    @Test
    void shouldContainLogoAndSearchBoxOnTheHomePageAndLoginPage() {
        Assertions.assertTrue(homePage.isMainLogoVisibleOnPage());
        Assertions.assertTrue(homePage.isSearchBarVisibleOnPage());
        homePage.clickSignInButton();
        Assertions.assertTrue(homePage.isMainLogoVisibleOnPage());
        Assertions.assertTrue(homePage.isSearchBarVisibleOnPage());
    }

    @Test
    void shouldVerifyCorrectNewsletterSubscription(){
        homePage.signForNewsletterWithNewEmailAndClickSubmit();
        Assertions.assertTrue(homePage.isSubscribedToNewsletter());
    }

    @Test
    void shouldNotSubscribeToNewsletterProperly(){
        homePage.signForNewsletterWithUsedEmailAndClickSubmit();
        Assertions.assertTrue(homePage.isNotSubscribedToNewsletter());
    }
}
