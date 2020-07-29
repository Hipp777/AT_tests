package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;

import java.util.List;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.group().goToGroupsPage();

        if (app.group().list().size()==0) {
            app.group().create();
        }
    }

    @Test
    public void testDelGroup() {

        List<GroupData> listBefore = app.group().list();
        int index=listBefore.size() - 1;
        app.group().delete(index);
        List<GroupData> listAfter = app.group().list();

        Assert.assertEquals(listAfter.size(), listBefore.size() - 1);
        listBefore.remove(index);
        // for (int i = 0; i < listAfter.size(); i++) {
        //      Assert.assertEquals(listAfter.get(i), listBefore.get(i));
        // }
        Assert.assertEquals(listBefore, listAfter);



    }

}
