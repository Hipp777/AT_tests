package testSelenium.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String baseUrl;

    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;

    public void init() {
        String path = "E:\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
