package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;
import testSelenium.model.UserData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by 1 on 22.06.2020.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void addContact() {
        navigateToCreateContactForm();
        fillNewUserForm(new UserData("new user test name", "Second test name", "Testtest", "123454", "3454535", "11", "October", "1999"));
        submitNewUserForm();
    }

    public void submitNewUserForm() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillNewUserForm(UserData userData) {

        type(By.name("firstname"), userData.getName());
        type(By.name("middlename"), userData.getSecondName());
        type(By.name("nickname"), userData.getNickName());
        type(By.name("home"), userData.getHomePhone());
        type(By.name("mobile"), userData.getMobilePhone());
        click(By.name("work"));
        click(By.name("bday"));
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(userData.getBirthdayDay());
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(userData.getBirthdayMonth());
        click(By.name("bmonth"));
        type(By.name("byear"), userData.getBirthdayYear());
    }

    public void navigateToCreateContactForm() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void selectSecondContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td/input"));
        acceptNextAlert = true;
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void editContactOnHomePage() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void fillUserFormFromEdit(UserData userData) {
        type(By.name("firstname"), userData.getName());
        type(By.name("middlename"), userData.getSecondName());
        type(By.name("nickname"), userData.getNickName());
    }

    public void submitEditform() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public boolean checkSecondContact() {
        return isElementPresent(By.name("//table[@id='maintable']/tbody/tr[3]/td/input"));
    }
    public int getContactCount (){
        return  driver.findElements(By.name("selected[]")).size();
    }
    public boolean checkFirstContact() {
        return isElementPresent(By.name("selected[]"));
    }

   /* public List<UserData> getContactList() {
        List <UserData> users = new ArrayList<UserData>();
        List <WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for(WebElement element:elements){
            String name = element.getText();
            GroupData group = new GroupData(name, null,null);
            users.add(group);
        }
        return users;
    }*/
  /* public List<UserData> getContactList() {
       List <UserData> users = new ArrayList<UserData>();
       //List <WebElement> elements = driver.findElements(By.cssSelector("[name=entry]"));
       List <WebElement> elements = driver.findElements(By.name("entry"));
       for(WebElement element:elements){
           String name = element.getText();
           String id = element.findElement(By.tagName("input")).getAttribute("id");
           int id_i = Integer.parseInt(id);
           UserData user = new UserData(id_i, name, null,null);
           groups.add(group);
       }
       return groups;
   }*/
}
