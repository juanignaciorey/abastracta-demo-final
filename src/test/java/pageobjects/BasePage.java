package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    private static final WebDriverWait wait;

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        java.time.Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void focusOn(String locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(Find(locator));
        actions.perform();
    }

    public void pressPage_UP() {
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_UP).build().perform();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String path = "../screens/screen_" + result.getName() + ".png";
                FileHandler.copy(screenshotFile, new File(path));
                result.setAttribute("screenshotPath", path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
