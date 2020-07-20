package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.GroupData;

import java.util.List;

public class TestAddGroup extends TestBase {

    @Test
    public void testFirst() throws Exception {
        app.getGroupHelper().goToGroupsPage();
        // int  before = app.getGroupHelper().getGroupCount();
        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().startGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test group 1", "Logo test", "Footer test"));
        app.getGroupHelper().submitGroupForm();
        app.getGroupHelper().goToGroupsPage();
        //int  after = app.getGroupHelper().getGroupCount();
        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        app.logout();
        Assert.assertEquals(listAfter.size(), listBefore.size() + 1);
    }

}

