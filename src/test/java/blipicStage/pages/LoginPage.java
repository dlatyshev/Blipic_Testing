package blipicStage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginPage {
   public static final String url = "https://stage.blipic.co/#/login";
   public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(name = "authLogin")
    private WebElement loginField;

    @FindBy(name = "authPassword")
    private WebElement passwordField;

    @FindBy(partialLinkText = "Forgot password")
    private WebElement forgotPassLink;

    @FindBy(css = "input.ng-touched:nth-child(2)")
    private WebElement activCodeField;

    @FindBy(xpath = "//div[@class='alert alert-danger']//span[contains(text(),'Incorrect login or password.')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@placeholder='Activation code']")
    private WebElement activationCodeField;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-blipic-primary']")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//h4[@class='left title-header']")
    public WebElement recoveryPasswordHeader;

    @FindBy(xpath = "//input[@ng-model = 'forgotLogin']")
    private WebElement forgotLogin;

    @FindBy(xpath = "//input[@ng-model = 'newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@ng-model = 'newPassword2']")
    private WebElement confirmNewPasswordField;

    @FindBy(xpath = "//button[contains(text(),'Back')]")
    private WebElement backBtn;

    @FindBy(xpath = "//button[contains(text(),'Send New Password')]")
    private WebElement sendNewPasswordBtn;

    @FindBy(xpath = "//h4[@class='left']")
    public WebElement existingAccountHeader;

    @FindBy(xpath = "//div[@class='alert ng-scope alert-danger']//span[@class='ng-binding'][contains(text(),'Invalid password value')]")
    private WebElement invalidPasswordMessage;

    @FindBy(xpath = "//div[@class='alert ng-scope alert-danger']//span[@class='ng-binding'][contains(text(),'Error. Please type your username or email.')]")
    private WebElement emptyFieldsErrorMessage;

    @FindBy(xpath = "//div[@class='alert ng-scope alert-danger']//span[@class='ng-binding'][contains(text(),'Passwords do not match')]")
    private WebElement passwordsDoNotMatchErrorMessage;

    @FindBy(xpath = "//div[@class='alert ng-scope alert-success']//span[contains(text(),'Check your mailbox for verification code.')]")
    private WebElement verificationCodeMessage;


    public void enterLogin(String login){
        loginField.sendKeys(login);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }

    public boolean checkErrorMessage(){
        return errorMessage.isDisplayed() &&
                errorMessage.getText().equals("Incorrect login or password.");
    }

    public boolean checkInvalidPasswordMessage(){
        return invalidPasswordMessage.isDisplayed() &&
               invalidPasswordMessage.getText().equals("Invalid password value");
    }

    public boolean checkEmptyFieldsErrorMessage(){
        return emptyFieldsErrorMessage.isDisplayed() &&
               emptyFieldsErrorMessage.getText().equals("Error. Please type your username or email.");
    }

    public boolean checkPasswordDoNotMatchErrorMessage(){
        return passwordsDoNotMatchErrorMessage.isDisplayed() &&
               passwordsDoNotMatchErrorMessage.getText().equals("Passwords do not match");
    }

    public boolean checkVerificationCodeMessage(){
        return verificationCodeMessage.isDisplayed() &&
               verificationCodeMessage.getText().equals("Check your mailbox for verification code.");
    }

    public void clearFields(){
        loginField.clear();
        passwordField.clear();
    }

    public void clickForgotPassword(){
        forgotPassLink.click();
    }

    public void enterUserNameOrEmail(String login){
        forgotLogin.sendKeys(login);
    }

    public void enterNewPassword(String password){
        newPasswordField.sendKeys(password);
    }

    public void confirmNewPassword(String password){
        confirmNewPasswordField.sendKeys(password);
    }

    public void clickBackBtn(){
        backBtn.click();
    }

    public void clickSendNewPasswordBtn(){
        sendNewPasswordBtn.click();
    }

}
