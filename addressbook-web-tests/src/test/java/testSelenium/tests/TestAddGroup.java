package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class TestAddGroup extends TestBase {

    @Test
    public void testFirst() throws Exception {
        app.getGroupHelper().goToGroupsPage();

        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().startGroupCreation();
        GroupData group = new GroupData("Test group 2", "Logo test", "Footer test");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupForm();
        app.getGroupHelper().goToGroupsPage();

        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(listAfter.size(), listBefore.size() + 1);
        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());

        listBefore.sort(byId);
        listAfter.sort(byId);

        listBefore.add(group);
        Assert.assertEquals(listBefore,listAfter);
        app.logout();

    }

}

