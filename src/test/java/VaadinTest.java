import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class VaadinTest {
    private WebDriver driver;

    private String baseUrl = "https://demo.vaadin.com/dashboard/#!dashboard";
    private By emailFl = By.id("gwt-uid-4");
    private By passwordFl = By.id ("gwt-uid-6");
    private By signInBtn = By.xpath("//div[contains(@class, 'v-button-primary')]");
    private By closePopUpBtn = By.xpath("//div[@class='popupContent']");
    private By mainScreenNotes = By.xpath("//textarea[@rows='5']");
    private By mainScreenUserMenu = By.xpath("(//span[@class='v-menubar-menuitem-caption'])[1]");
    private By mainScreenEditProfile = By.xpath("//span[text()='Edit Profile']");
    private By profileScreenTitle = By.id("gwt-uid-16");
    private By profileScreenSexMale = By.xpath("//div[@id='gwt-uid-18']//span[contains(., 'Male')]");
    private By profileScreenSexFemale = By.xpath("//div[@id='gwt-uid-18']//span[contains(., 'Female')]");

    @BeforeTest
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void vaadinTest() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(5000);
        driver.findElement(closePopUpBtn).click();
        Thread.sleep(5000);
        driver.findElement(emailFl).sendKeys("True Automation");
        driver.findElement(passwordFl).sendKeys("admin");
        driver.findElement(signInBtn).click();

        Thread.sleep(5000);
        driver.findElement(mainScreenNotes).sendKeys("\nTrue Automation\nBest Test Automation Framework");
        Thread.sleep(5000);
        driver.findElement(mainScreenUserMenu).click();
        driver.findElement(mainScreenEditProfile).click();
        Thread.sleep(5000);
        driver.findElement(profileScreenTitle).sendKeys("Mrs.");
        driver.findElement(profileScreenTitle).click();
        Thread.sleep(5000);
        driver.findElement(profileScreenSexMale).click();
        driver.findElement(profileScreenSexFemale).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}
