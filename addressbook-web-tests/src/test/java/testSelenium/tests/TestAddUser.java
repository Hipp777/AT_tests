package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.GroupData;
import testSelenium.model.UserData;

import java.util.List;


public class TestAddUser extends TestBase {

    @Test
    public void testSecondTestAddUser() throws Exception {
        int before = app.getContactHelper().getContactCount();
       // List<UserData> listBefore = app.getContactHelper().getContactList();
        app.getContactHelper().addContact();
        app.getNavigationHelper().navigateToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
        app.logout();
    }

}
