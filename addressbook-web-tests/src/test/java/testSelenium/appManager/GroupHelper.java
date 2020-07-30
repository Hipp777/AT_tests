package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testSelenium.model.GroupData;
import testSelenium.model.Groups;

import java.util.List;

/**
 * Created by 1 on 22.06.2020.
 */
public class GroupHelper extends HelperBase {
    private Groups groupCache = null;

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

    public void create(GroupData group) {
        goToGroupsPage();
        startGroupCreation();
        fillGroupForm(group);
        submitGroupForm();
        groupCache = null;
        goToGroupsPage();
    }
    public void create() {
        goToGroupsPage();
        startGroupCreation();
        fillGroupForm(new GroupData().withHeader("defoultGroupData"));
        submitGroupForm();
        groupCache = null;
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
        if (groupCache != null) {
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            int id_i = Integer.parseInt(id);
            groupCache.add(new GroupData().withId(id_i).withName(name));
        }
        return new Groups(groupCache);
    }

    public void modify(GroupData groupData) {
        goToGroupsPage();
        selectGroupById(groupData.getId());
        startEditGroup();
        fillGroupForm(groupData);
        submitEditGroup();
        groupCache = null;
        goToGroupsPage();

    }

    public void delete(GroupData group) {

        selectGroupById(group.getId());
        deleteGroup();
        groupCache = null;
        goToGroupsPage();
    }

    private void selectGroupById(int id) {
        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
}
