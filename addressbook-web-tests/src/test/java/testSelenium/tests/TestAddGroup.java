package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class TestAddGroup extends TestBase {

    @Test
    public void testFirst() throws Exception {
        app.group().goToGroupsPage();

        List<GroupData> listBefore = app.group().list();
        app.group().startGroupCreation();
        GroupData group = new GroupData().withName("Test group 2").withHeader("Logo test").withFooter("Footer test");
        app.group().fillGroupForm(group);
        app.group().submitGroupForm();
        app.group().goToGroupsPage();

        List<GroupData> listAfter = app.group().list();
        Assert.assertEquals(listAfter.size(), listBefore.size() + 1);
        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());

        listBefore.sort(byId);
        listAfter.sort(byId);

        listBefore.add(group);
        Assert.assertEquals(listBefore,listAfter);

    }

}

