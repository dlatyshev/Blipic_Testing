package blipicStage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
   public static final String url = "https://stage.blipic.co/#/login";
   public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(tagName = "button")
    private WebElement loginBtn;

    @FindBy(name = "authLogin")
    private WebElement loginField;

    @FindBy(name = "authPassword")
    private WebElement passwordField;

    @FindBy(linkText = "Forgot password")
    private WebElement forgotPassLink;

    @FindBy(css = "input.ng-touched:nth-child(2)")
    private WebElement activCodeField;


    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }

    public void clickForgotPassword(){
        forgotPassLink.click();
    }
}
