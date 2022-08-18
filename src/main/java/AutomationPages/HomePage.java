package AutomationPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "logo")
    WebElement mainLogo;
    @FindBy(className = "search_query")
    WebElement searchBar;
    @FindBy(className = "login")
    WebElement signInButton;
    @FindBy(className = "inputNew")
    WebElement newsletterInputBox;
    @FindBy(name = "submitNewsletter")
    WebElement newsletterSubmitButton;
    @FindBy(className = "alert-success")
    WebElement newsletterAlertSuccess;
    @FindBy(className = "alert-danger")
    WebElement newsletterAlertFailed;

    public void clickSignInButton(){
        signInButton.click();
    }

    public void newsletterSubmitButtonClick(){
        newsletterSubmitButton.click();
    }

    public boolean isMainLogoVisibleOnPage(){
        return mainLogo.isDisplayed();
    }

    public boolean isSearchBarVisibleOnPage(){
        return searchBar.isDisplayed();
    }

    public void signForNewsletterWithNewEmailAndClickSubmit(){
        newsletterInputBox.sendKeys("test123qwerty@tester.com");
        newsletterSubmitButtonClick();
    }

    public void signForNewsletterWithUsedEmailAndClickSubmit(){
        newsletterInputBox.sendKeys("test@tester.com");
        newsletterSubmitButtonClick();
    }

    public boolean isSubscribedToNewsletter(){
        return newsletterAlertSuccess.isDisplayed();
    }

    public boolean isNotSubscribedToNewsletter(){
        return newsletterAlertFailed.isDisplayed();
    }
}
