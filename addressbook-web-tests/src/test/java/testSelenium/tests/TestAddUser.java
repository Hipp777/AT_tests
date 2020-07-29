package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestAddUser extends TestBase {

    @Test
    public void testSecondTestAddUser() throws Exception {
        int before = app.getContactHelper().getContactCount();
       // List<UserData> listBefore = app.getContactHelper().getContactList();
        app.getContactHelper().addContact();
        app.goTo().homePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);

    }

}
