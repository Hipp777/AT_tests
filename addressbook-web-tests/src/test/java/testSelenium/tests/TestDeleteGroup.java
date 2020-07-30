package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testSelenium.model.GroupData;
import testSelenium.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.group().goToGroupsPage();

        if (app.group().all().size()==0) {
            app.group().create();
        }
    }

    @Test
    public void testDelGroup() {

        Groups listBefore = app.group().all();
        GroupData deletedGroup=listBefore.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().getGroupCount(), equalTo(listBefore.size()-1));
        Groups listAfter = app.group().all();

        Assert.assertEquals(listAfter.size(), listBefore.size() - 1);

        // for (int i = 0; i < listAfter.size(); i++) {
        //      Assert.assertEquals(listAfter.get(i), listBefore.get(i));
        // }
        assertThat(listAfter, equalTo(listBefore.withOut(deletedGroup)));

    }

}
