package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestEditGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().goToGroupsPage();

        if (app.group().list().size()==0) {
            app.group().create();
        }
    }

    @Test
    public void editFirstGroup() {

        List<GroupData> listBefore = app.group().list();
        GroupData groupData = new GroupData().
                withId(listBefore.get(listBefore.size() - 1).getId()).withName("test1").withHeader("test2").withFooter("test3");
        int index = listBefore.size() - 1;
        app.group().modify(groupData, index);

        List<GroupData> listAfter = app.group().list();
        Assert.assertEquals(listAfter.size(), listBefore.size());

        listBefore.remove(listBefore.size() - 1);
        listBefore.add(groupData);
        // Assert.assertEquals(new HashSet<Object>(listBefore),new HashSet<Object>(listAfter));
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);
        Assert.assertEquals(listBefore, listAfter);

    }

}



