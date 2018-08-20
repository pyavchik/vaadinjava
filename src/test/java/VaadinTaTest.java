import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class VaadinTaTest {
    private WebDriver driver;
    private Utils utils;

    private String baseUrl = "https://demo.vaadin.com/dashboard/#!dashboard";
    private By emailFl = By.id(ta("ta:emailFl", "gwt-uid-4"));
    private By passwordFl = By.id(ta("ta:passwordFl", "gwt-uid-6"));
    private By signInBtn = By.xpath(ta("ta:signInBtn", "//div[contains(@class, 'v-button-primary')]"));
    private By closePopUpBtn = By.xpath(ta("ta:closePopUpBtn", "//div[@class='popupContent']"));
    private By mainScreenNotes = By.xpath(ta("vaadinDashboard:MainScreen:notes", "//textarea[@rows='5']"));
    private By mainScreenUserMenu = By.xpath(ta("vaadinDashboard:MainScreen:userMenu", "(//span[@class='v-menubar-menuitem-caption'])[1]"));
    private By mainScreenEditProfile = By.xpath(ta("vaadinDashboard:MainScreen:editProfile", "//span[text()='Edit Profile']"));


    private By profileScreenTitle = By.id(ta("vaadinDashboard:ProfileScreen:title", "gwt-uid-16"));
    private By profileScreenSexMale = By.xpath(ta("vaadinDashboard:ProfileScreen:sexMale", "//div[@id='gwt-uid-18']//span[contains(., 'Male')]"));
    private By profileScreenSexFemale = By.xpath(ta("vaadinDashboard:ProfileScreen:sexFemale", "//div[@id='gwt-uid-18']//span[contains(., 'Female')]"));

    private By profileScreenFirstName = By.id(ta("vaadinDashboard:ProfileScreen:firstName", "gwt-uid-12"));
    private By profileScreenSecondName = By.id(ta("vaadinDashboard:ProfileScreen:secondName", "gwt-uid-14"));

    private By profileScreenSave = By.xpath(ta("vaadinDashboard:ProfileScreen:save", "//div[contains(@class, 'v-button-primary')]"));



    @BeforeTest
    public void before(){
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        utils = new Utils(driver);
    }

    @Test
    public void vaadinTest() {
        driver.get(baseUrl);

        utils.isElementClickable(closePopUpBtn, 10);
        driver.findElement(closePopUpBtn).click();

        utils.isElementClickable(emailFl, 10);
        driver.findElement(emailFl).sendKeys("True Automation");
        driver.findElement(passwordFl).sendKeys("admin");
        driver.findElement(signInBtn).click();

        for(int i = 0; i < 2; i++) {

            utils.isElementClickable(mainScreenNotes, 10);
            driver.findElement(mainScreenNotes).sendKeys("\nTrue Automation\nBest Test Automation Framework");
            driver.findElement(mainScreenUserMenu).click();

            utils.isElementClickable(mainScreenEditProfile, 10);
            driver.findElement(mainScreenEditProfile).click();

            utils.isElementClickable(profileScreenFirstName, 10);
            driver.findElement(profileScreenFirstName).sendKeys("Douglas");
            driver.findElement(profileScreenSecondName).sendKeys("Engelbart");

            driver.findElement(profileScreenTitle).sendKeys("Mrs.");
            driver.findElement(profileScreenTitle).click();

            driver.findElement(profileScreenSexMale).click();
            driver.findElement(profileScreenSexFemale).click();

            driver.findElement(profileScreenSave).click();
        }
    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}
