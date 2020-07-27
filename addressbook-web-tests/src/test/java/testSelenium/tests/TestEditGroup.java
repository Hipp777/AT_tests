package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
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

        List<GroupData> listBefore = app.getGroupHelper().getGroupList();
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().selectGroup(listBefore.size()-1);
        app.getGroupHelper().startEditGroup();
        GroupData groupData = new GroupData(listBefore.get(listBefore.size()-1).getId(),"test1","test2","test3");
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().submitEditGroup();
        app.getGroupHelper().goToGroupsPage();

        List<GroupData> listAfter = app.getGroupHelper().getGroupList();
        Assert.assertEquals(listAfter.size(), listBefore.size());

        listBefore.remove(listBefore.size()-1);
        listBefore.add(groupData);
       // Assert.assertEquals(new HashSet<Object>(listBefore),new HashSet<Object>(listAfter));
        Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);
        Assert.assertEquals(listBefore,listAfter);
        app.logout();

    }
}



