package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.UserData;


public class TestAddUser extends TestBase {

    @Test
    public void testSecondTestAddUser() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().addContact();
        app.getNavigationHelper().navigateToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
        app.logout();
    }

}
