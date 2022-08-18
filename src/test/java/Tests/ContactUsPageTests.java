package Tests;

import AutomationPages.ContactUsPage;
import BaseForTests.BaseForTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactUsPageTests extends BaseForTests {

    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @Test
    void shouldNotSendMessageWithoutSubjectHeading(){
        contactUsPage.goToContactUsPage();
        contactUsPage.enterEmailAddressMessageAndClickSend();
        Assertions.assertTrue(contactUsPage.isMessageNotSent());
    }

    @Test
    void shouldSendMessageProperly(){
        contactUsPage.goToContactUsPage();
        contactUsPage.sendMessageProperly();
        Assertions.assertTrue(contactUsPage.isMessageSent());
    }
}
