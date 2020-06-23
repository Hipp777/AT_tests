package testSelenium.tests;

import org.testng.annotations.Test;
import testSelenium.model.GroupData;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestEditGroup extends TestBase {
    @Test
    public void editFirstGroup() {
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().startEditGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("testEdit1", "Test edit 2", "Testedit3"));
        app.getGroupHelper().submitEditGroup();
        app.getGroupHelper().goToGroupsPage();
        app.logout();
    }
}
