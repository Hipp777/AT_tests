package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 1 on 22.06.2020.
 */
public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {

        super(driver);
    }
    public void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"),password);
        click(By.id("LoginForm"));
        click(By.xpath("//input[@value='Login']"));
    }
}
