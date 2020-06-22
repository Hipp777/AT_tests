package testSelenium.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testSelenium.model.GroupData;

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
        type (By.name("group_footer"),groupData.getFooter());

    }

    public void startGroupCreation() {
        click(By.name("new"));
    }

    public void goToGroupsPage() {
      click(By.linkText("groups"));
    }
}
