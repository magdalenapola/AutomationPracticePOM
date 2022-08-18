package AutomationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailInputCreateAcc;
    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;
    @FindBy(id = "email")
    WebElement emailInputLogIn;
    @FindBy(id = "passwd")
    WebElement passwordInputLogIn;
    @FindBy(id = "SubmitLogin")
    WebElement logInButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]//li")
    WebElement logInError;
    @FindBy(id = "create_account_error")
    WebElement accountAlreadyExistsError;
    @FindBy(className = "login")
    public WebElement signInButton;

    public void properLogIn(){

        emailInputLogIn.sendKeys("iamrobot@test.com");
        passwordInputLogIn.sendKeys("12345");
        logInButton.click();
    }

    public void logInWithoutEmail(){
        passwordInputLogIn.sendKeys("12345");
        logInButton.click();
    }

    public void logInWithoutPassword(){
        emailInputLogIn.sendKeys("iamrobot@test.com");
        logInButton.click();
    }

    public String verifyNoEmailError(){
        return logInError.getText();
    }

    public String verifyNoPasswordError(){
        return logInError.getText();
    }

    public boolean isOnMyAccountPage(){
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    public void registerWithExistingEmail(){
        emailInputCreateAcc.sendKeys("iamrobot@test.com");
        createAccountButton.click();
    }

    public boolean isNotRegistered(){
        return accountAlreadyExistsError.isDisplayed();
    }

}
