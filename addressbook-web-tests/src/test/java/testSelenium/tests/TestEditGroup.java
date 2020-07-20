package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;

import java.util.List;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestEditGroup extends TestBase {
    @Test
    public void editFirstGroup() {
        int after;
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().checkFirstGroup()) {
            app.getGroupHelper().addGroup();
        }
       // int before = app.getGroupHelper().getGroupCount();
        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().startEditGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("testEdit222", "Test edit 2", "Testedit3"));
        app.getGroupHelper().submitEditGroup();
        app.getGroupHelper().goToGroupsPage();
       // after = app.getGroupHelper().getGroupCount();
        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(listAfter.size(), listBefore.size());
        app.logout();

    }
}



