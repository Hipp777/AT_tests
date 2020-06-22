package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 1 on 22.06.2020.
 */
public class NavigationHelper extends HelperBase{
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
      click(By.linkText("home page"));
    }
}
