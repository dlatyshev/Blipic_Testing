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

    @FindBy(xpath = "//div[@class='text-box-info center']") // !!
    private WebElement employeeParticipationLanding;

    @FindBy(xpath = "//div[@class='text-box-info left']") // !!
    private WebElement onBoardEmployeesLanding;

    @FindBy(xpath = "//div[@class='text-box-info right']") // !!
    private WebElement createOrganizedActivityLanding;

    @FindBy(xpath = "//div[@class='text-box-info top']") // !!
    private WebElement description;

    @FindBy(xpath = "//a[@ng-href='#/onboard']")
    private WebElement onboardEmployeesBtn;

    @FindBy(xpath = "//a[@ng-href='#/participation']")
    private WebElement employeeParticipationBtn;

    @FindBy(xpath = "//a[@ng-href='#/challenges']")
    private WebElement teamChallengesBtn;

    @FindBy(xpath = "//a[@ng-href='#/calendars']")
    private WebElement calendarsBtn;

    @FindBy(xpath = "//a[@ng-href='#/resources']")
    private WebElement resourceBtn;

    @FindBy(xpath = "//a[@ng-href='#/users']")
    private WebElement hrUsersBtn;

    @FindBy(xpath = "//a[@ng-href='#/account-settings']")
    private WebElement accoutSettingsBtn;

    @FindBy(id = "sidebarToggleButton")
    private WebElement sidebarBtn;




    public boolean checkSideMenuElements(){
        return onboardEmployeesBtn.isDisplayed() && employeeParticipationBtn.isDisplayed() &&
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
    public void clickResourcesBtn() {resourceBtn.click();}
    public void clickHrUsersBtn(){hrUsersBtn.click();}
    public void clickAccountSettingsBtn(){accoutSettingsBtn.click();}
    public void clickSidebarBtn(){sidebarBtn.click();}
    public void clickEmployeeParticipationLanding(){
        employeeParticipationLanding.click();
    }
    public void clickOnboardEmployeesLanding(){
        onBoardEmployeesLanding.click();
    }
    public void clickCreateOrganizedActivityLanding(){
        createOrganizedActivityLanding.click();
    }


}
