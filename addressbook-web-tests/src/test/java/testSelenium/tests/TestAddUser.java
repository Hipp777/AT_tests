package testSelenium.tests;

import org.testng.annotations.*;
import testSelenium.model.UserData;


public class TestAddUser extends TestBase {

    @Test
    public void testSecondTestAddUser() throws Exception {
        app.getContactHelper().addContact();
        app.getNavigationHelper().navigateToHomePage();
        app.logout();
    }

}
