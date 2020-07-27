package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;

import java.util.List;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @Test
    public void testDelGroup() {
        int after;
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().checkFirstGroup()) {
            app.getGroupHelper().addGroup();
        }
        //  int before = app.getGroupHelper().getGroupCount();
        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(listBefore.size() - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().goToGroupsPage();
        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        // after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(listAfter.size(), listBefore.size() - 1);
        listBefore.remove(listBefore.size() - 1);
        // for (int i = 0; i < listAfter.size(); i++) {
        //      Assert.assertEquals(listAfter.get(i), listBefore.get(i));
        // }
        Assert.assertEquals(listBefore, listAfter);

        app.logout();

    }

}
