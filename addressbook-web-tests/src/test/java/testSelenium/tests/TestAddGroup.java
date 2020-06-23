package testSelenium.tests;

import org.testng.annotations.*;
import testSelenium.model.GroupData;

public class TestAddGroup extends TestBase {

    @Test
    public void testFirst() throws Exception {

        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().startGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test group 1", "Logo test", "Footer test"));
        app.getGroupHelper().submitGroupForm();
        app.getGroupHelper().goToGroupsPage();
        app.logout();
    }

}

