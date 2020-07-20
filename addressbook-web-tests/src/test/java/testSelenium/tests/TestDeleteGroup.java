package testSelenium.tests;

import org.testng.annotations.Test;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @Test
    public void testDelGroup() {
        if (app.getGroupHelper().checkFirstGroup()) {
            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().deleteGroup();
            app.getGroupHelper().goToGroupsPage();
            app.logout();
        } else {
            app.getGroupHelper().addGroup();

            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().deleteGroup();
            app.getGroupHelper().goToGroupsPage();
            app.logout();
        }
    }

}
