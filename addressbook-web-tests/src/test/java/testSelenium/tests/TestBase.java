package testSelenium.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testSelenium.appManager.ApplicationManager;


public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
