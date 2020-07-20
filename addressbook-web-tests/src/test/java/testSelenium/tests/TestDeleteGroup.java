package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @Test
    public void testDelGroup() {
        int after;
        app.getGroupHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        if (app.getGroupHelper().checkFirstGroup()) {
            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().deleteGroup();
            app.getGroupHelper().goToGroupsPage();
            after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, before - 1);
            app.logout();
        } else {
            app.getGroupHelper().addGroup();

            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().deleteGroup();
            app.getGroupHelper().goToGroupsPage();
            after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, before);
            app.logout();
        }

    }

}
