package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testSelenium.model.GroupData;
import testSelenium.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 22.06.2020.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());

    }

    public void startGroupCreation() {
        click(By.name("new"));
    }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }

    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public boolean checkFirstGroup() {
        goToGroupsPage();

        return isElementPresent(By.name("selected[]"));
    }

    public void create() {
        goToGroupsPage();
        startGroupCreation();
        fillGroupForm(new GroupData().withName("Test2"));
        submitGroupForm();
        goToGroupsPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteGroup();
        goToGroupsPage();
    }

    public void startEditGroup() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void submitEditGroup() {
        click(By.name("update"));
    }

    public void deleteGroup() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            int id_i = Integer.parseInt(id);
            groups.add(new GroupData().withId(id_i).withName(name));
        }
        return groups;
    }

    public void modify(GroupData groupData) {
        goToGroupsPage();
        selectGroupById(groupData.getId());
        startEditGroup();
        fillGroupForm(groupData);
        submitEditGroup();
        goToGroupsPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteGroup();
        goToGroupsPage();
    }

    private void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id +"']")).click();
    }
}
