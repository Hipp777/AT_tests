package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import testSelenium.model.UserData;

/**
 * Created by 1 on 22.06.2020.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }
    public void submitNewUserForm() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }
    public void fillNewUserForm(UserData userData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(userData.getName());
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(userData.getSecondName());
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(userData.getNickName());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(userData.getHomePhone());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(userData.getMobilePhone());
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(userData.getBirthdayDay());
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(userData.getBirthdayMonth());
        driver.findElement(By.name("bmonth")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(userData.getBirthdayYear());
        driver.findElement(By.name("ayear")).click();
    }

    public void navigateToCreateUserForm() {
        driver.findElement(By.linkText("add new")).click();
    }
}
