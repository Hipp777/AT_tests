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
public class TestEditGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().goToGroupsPage();

        if (app.group().all().size()==0) {
            app.group().create();
        }
    }

    @Test
    public void editFirstGroup() {

        Groups listBefore = app.group().all();
        GroupData editedGroup=listBefore.iterator().next();
        GroupData groupData = new GroupData().
                withId(editedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(groupData);
        assertThat(app.group().getGroupCount(), equalTo(listBefore.size()));
        Groups listAfter = app.group().all();
        Assert.assertEquals(listAfter.size(), listBefore.size());

      /*  listBefore.remove(editedGroup);
        listBefore.add(groupData);
        // Assert.assertEquals(new HashSet<Object>(listBefore),new HashSet<Object>(listAfter));*/
        assertThat(listAfter, equalTo(listBefore.withOut(editedGroup).withAdded(groupData)));
    }

}



