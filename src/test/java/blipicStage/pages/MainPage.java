package blipicStage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public static final String url = "https://stage.blipic.co/#/main";
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Blipic")
    private WebElement logo;

    @FindBy(linkText = "Logout")
    private WebElement logout;
    /*
    Change class names. They should not contain spaces.
     */
    @FindBy(className = "text-box-info center") // !!
    private WebElement employeeParticipation;

    @FindBy(className = "text-box-info left") // !!
    private WebElement onBoardEmployees;

    @FindBy(className = "text-box-info right") // !!
    private WebElement calendar;

    @FindBy(className = "text-box-info top") // !!
    private WebElement description;
}
