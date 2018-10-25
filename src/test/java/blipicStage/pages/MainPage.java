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
    @FindBy(xpath = "//div[@class='text-box-info center']") // !!
    private WebElement employeeParticipation;

    @FindBy(xpath = "//div[@class='text-box-info left']") // !!
    private WebElement onBoardEmployees;

    @FindBy(xpath = "//div[@class='text-box-info right']") // !!
    private WebElement calendar;

    @FindBy(xpath = "//div[@class='text-box-info left']") // !!
    private WebElement description;

    @FindBy(linkText = "Onboard Employees")
    private WebElement onboardEmployeesBtn;

    @FindBy(linkText = "Employee Participation")
    private WebElement employeeParticipationBtn;

    @FindBy(linkText = "Team Challenges")
    private WebElement teamChallengesBtn;

    @FindBy(linkText = "Calendars")
    private WebElement calendarsBtn;

    @FindBy(linkText = "Resources")
    private WebElement resourceBtn;

    @FindBy(linkText = "HR Users")
    private WebElement hrUsersBtn;

    @FindBy(linkText = "Account settings")
    private WebElement accoutSettingsBtn;


    public boolean checkSideMenuElements(){
        return onBoardEmployees.isDisplayed() && employeeParticipation.isDisplayed() &&
                teamChallengesBtn.isDisplayed() && calendarsBtn.isDisplayed() &&
                resourceBtn.isDisplayed() && hrUsersBtn.isDisplayed() &&
                accoutSettingsBtn.isDisplayed();
    }

    public void clickOnboardEmployeesBtn(){
        onboardEmployeesBtn.click();
    }
    public void clickEmployeeParticipationBtn(){
        employeeParticipationBtn.click();
    }
    public void clickTeamChallengesBtn(){
        teamChallengesBtn.click();
    }
    public void clickCalendarsBtn(){
        calendarsBtn.click();
    }



}
