package AutomationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    WebElement subjectSelection;

    @FindBy(id = "email")
    WebElement emailAddressInput;

    @FindBy(id = "message")
    WebElement messageBoxInput;

    @FindBy(id = "submitMessage")
    WebElement sendMessageButton;

    @FindBy(className = "alert-success")
    WebElement messageSentSuccess;

    @FindBy(className = "alert-danger")
    WebElement messageNotSentError;

    @FindBy(id = "contact-link")
    WebElement contactUsButton;

    public void goToContactUsPage(){
        contactUsButton.click();
    }

    public void chooseMessageSubject() {
        Select select = new Select(subjectSelection);
        select.selectByValue("2");
    }

    public void enterEmailAddressMessageAndClickSend(){
        emailAddressInput.sendKeys("test@test.com");
        messageBoxInput.sendKeys("sample message");
        sendMessageButton.click();
    }

    public void sendMessageProperly(){
        subjectSelection.click();
        chooseMessageSubject();
        emailAddressInput.sendKeys("test@test.com");
        messageBoxInput.sendKeys("sample message");
        sendMessageButton.click();
    }

    public boolean isMessageNotSent(){
        return messageNotSentError.isDisplayed();
    }

    public boolean isMessageSent(){
        return messageSentSuccess.isDisplayed();
    }

}
