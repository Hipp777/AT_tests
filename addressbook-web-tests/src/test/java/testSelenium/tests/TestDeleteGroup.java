package testSelenium.tests;

import org.testng.annotations.Test;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestDeleteGroup extends TestBase {
    @Test
    public void testDelGroup() {
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().selectFirstGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().goToGroupsPage();
        app.logout();
    }

}
