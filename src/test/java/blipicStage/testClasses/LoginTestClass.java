package blipicStage.testClasses;

import blipicStage.pages.LoginPage;
import blipicStage.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static blipicStage.pages.LoginPage.url;

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

    @AfterClass
    protected void TearDown(){
        if(driver != null){
            driver.quit();
        }
    }


    @Parameters({"login", "password"})
    @Test
    public void LogInToTheApp(String login, String password){
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlMatches(MainPage.url));
        Assert.assertEquals(driver.getCurrentUrl(), MainPage.url);
    }

    @Test
    public  void loginWithInvalidEmail(){

    }

    @Test
    public void loginWithInvalidPassword(){

    }




}