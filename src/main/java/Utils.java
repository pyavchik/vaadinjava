import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    WebDriver driver;
    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementClickable(By element, int timeout) {
        return this.waitForCondition(ExpectedConditions.elementToBeClickable(element), timeout);
    }

    private boolean waitForCondition(ExpectedCondition<WebElement> webElementExpectedCondition, int timeout) {
        try {
            new WebDriverWait(driver, timeout, 1000).until(webElementExpectedCondition);
            return true;
        } catch (TimeoutException e) {
            System.out.println("Condition failed!");
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Strange error");
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            new WebDriverWait(driver, timeout, 1000).until(webElementExpectedCondition);
            return true;
        }
    }
}
