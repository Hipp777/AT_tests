package testSelenium.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String baseUrl;
    private String browser;
    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        System.out.print(browser);
    }

    public void init() {
        if (browser == "chrome") {
            String path = "E:\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
        } else {
            if (browser == BrowserType.FIREFOX) {   //нет браузера на ПК, позже сделаю
                driver = new FirefoxDriver();
            } else {
                if (browser == BrowserType.IE) {
                    String path = "E:\\chromedriver_win32\\IEDriverServer.exe";
                    System.setProperty("webdriver.ie.driver", path);
                    driver = new InternetExplorerDriver();
                }
            }
        }

        baseUrl = "https://www.google.com/";
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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
