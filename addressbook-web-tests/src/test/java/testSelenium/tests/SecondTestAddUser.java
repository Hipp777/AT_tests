package testSelenium.tests;

import org.testng.annotations.*;
import testSelenium.model.UserData;


public class SecondTestAddUser extends TestBase {

    @Test
    public void testSecondTestAddUser() throws Exception {

        app.getContactHelper().navigateToCreateUserForm();
        app.getContactHelper().fillNewUserForm(new UserData("First test name", "Second test name", "Testtest", "123454", "3454535", "11", "October", "1999"));
        app.getContactHelper().submitNewUserForm();
        app.getNavigationHelper().navigateToHomePage();
        app.logout();
    }

}
