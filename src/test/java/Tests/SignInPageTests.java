package Tests;

import AutomationPages.HomePage;
import AutomationPages.SignInPage;
import BaseForTests.BaseForTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignInPageTests extends BaseForTests {

    SignInPage signInPage = new SignInPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    void shouldNotBeAbleToLoginIfEmailNotProvided(){
        homePage.clickSignInButton();
        signInPage.logInWithoutEmail();
        Assertions.assertEquals("An email address required.", signInPage.verifyNoEmailError());
    }

    @Test
    void shouldNotBeAbleToLogInIfPasswordNotProvided(){
        homePage.clickSignInButton();
        signInPage.logInWithoutPassword();
        Assertions.assertEquals("Password is required.", signInPage.verifyNoPasswordError());
    }

    @Test
    void shouldNotRegisterWithExistingEmail(){
        homePage.clickSignInButton();
        signInPage.registerWithExistingEmail();
        Assertions.assertTrue(signInPage.isNotRegistered());
    }

    @Test
    void shouldLogInProperly(){
        signInPage.signInButton.click();
        signInPage.properLogIn();
        Assertions.assertTrue(signInPage.isOnMyAccountPage());
    }
}
