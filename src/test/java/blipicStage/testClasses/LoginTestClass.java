package blipicStage.testClasses;

import blipicStage.pages.LoginPage;
import blipicStage.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTestClass {
    private LoginPage loginPage;
    private WebDriver driver;
    private WebDriverWait wait;


    @Parameters("browser")
    @BeforeClass
    private void setUp(String browser){
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 20);
        driver.get(LoginPage.url);

    }
    @AfterMethod
    public void refreshSystem(){
        if((driver.getCurrentUrl().equals(LoginPage.url)) &&
            loginPage.existingAccountHeader.isDisplayed()){
            loginPage.clearFields();
        } else if(loginPage.recoveryPasswordHeader.isDisplayed()) {
            loginPage.clickBackBtn();
        } else{
            driver.navigate().to(LoginPage.url);
        }
    }

    @AfterClass
    protected void TearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    @Test
    public void loginWithEmptyFields(){
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.checkErrorMessage());
    }

    @Parameters({"login", "password"})
    @Test
    public void LogInToTheApp(String login, String password){
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlMatches(MainPage.url));
        Assert.assertEquals(driver.getCurrentUrl(), MainPage.url);
        driver.navigate().back();
    }

    @Parameters({"login", "password"})
    @Test
    public  void loginWithInvalidEmail(String login, String password){
        loginPage.enterLogin(login.replace("ua", "us"));
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.checkErrorMessage());
    }
    @Parameters({"login", "password"})
    @Test()
    public void loginWithInvalidPassword(String login, String password){
        loginPage.enterLogin(login);
        loginPage.enterPassword(password + " ");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.checkErrorMessage());
        loginPage.clearFields();
        loginPage.enterLogin(login);
        loginPage.enterPassword(" " + password);
        Assert.assertTrue(loginPage.checkErrorMessage());
    }
    @Parameters("login")
    @Test
    public void loginWithEmptyPassword(String login){
        loginPage.enterLogin(login);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.checkErrorMessage());
    }

    @Test
    public void checkForgotPasswordLink(){
        loginPage.clickForgotPassword();
        Assert.assertTrue(loginPage.recoveryPasswordHeader.isDisplayed());
    }

    @Test
    public void checkBackBtn(){
        loginPage.clickForgotPassword();
        Assert.assertTrue(loginPage.recoveryPasswordHeader.isDisplayed());
        loginPage.clickBackBtn();
        Assert.assertTrue(loginPage.existingAccountHeader.isDisplayed());
    }

    @Parameters("login")
    @Test
    public void sendNewPasswordWithEmptyPassField(String login){
        loginPage.clickForgotPassword();
        loginPage.enterUserNameOrEmail(login);
        loginPage.clickSendNewPasswordBtn();
        Assert.assertTrue(loginPage.checkInvalidPasswordMessage());
    }

    @Test
    public void sendNewPasswordWithEmptyFields(){
        loginPage.clickForgotPassword();
        loginPage.clickSendNewPasswordBtn();
        Assert.assertTrue(loginPage.checkEmptyFieldsErrorMessage());
    }
    @Parameters({"login", "newPassword"})
    @Test
    public void sendNewPasswordWithEmptyConfirmPassword(String login, String newPassword){
        loginPage.clickForgotPassword();
        loginPage.enterUserNameOrEmail(login);
        loginPage.enterNewPassword(newPassword);
        loginPage.clickSendNewPasswordBtn();
        Assert.assertTrue(loginPage.checkPasswordDoNotMatchErrorMessage());
    }

    @Parameters({"login", "newPassword"})
    @Test
    public void sendNewPasswordWithInvalidConfirmPassword(String login, String newPassword){
        loginPage.clickForgotPassword();
        loginPage.enterUserNameOrEmail(login);
        loginPage.enterNewPassword(newPassword);
        loginPage.confirmNewPassword(newPassword + " ");
        loginPage.clickSendNewPasswordBtn();
        Assert.assertTrue(loginPage.checkPasswordDoNotMatchErrorMessage());
    }

    @Parameters({"login", "newPassword"})
    @Test
    public void sendNewPassword(String login, String newPassword){
        loginPage.clickForgotPassword();
        loginPage.enterUserNameOrEmail(login);
        loginPage.enterNewPassword(newPassword);
        loginPage.confirmNewPassword(newPassword);
        loginPage.clickSendNewPasswordBtn();
        Assert.assertTrue(loginPage.checkVerificationCodeMessage());
    }
    @Parameters({"login", "newPassword"})
    @Test
    public void sendEmptyVerificationCode(String login, String newPassword){
        sendNewPassword(login, newPassword);
        loginPage.clickSendCodeBtn();
        Assert.assertTrue(loginPage.checkInvalidVerificationCodeMessage());
    }

    @Parameters({"login", "newPassword"})
    @Test
    public void sendWrongVerificationCode(String login, String newPassword){
        sendNewPassword(login, newPassword);
        loginPage.enterVerificationCode("test");
        loginPage.clickSendCodeBtn();
        Assert.assertTrue(loginPage.checkInvalidVerificationCodeMessage());
    }










}
