package testSelenium.tests;

import org.testng.annotations.Test;
import testSelenium.model.UserData;


public class TestEditContact extends TestBase {
    @Test
    public void editFirstContact() {
        app.getContactHelper().selectfirstContactOnHomePage();
        app.getContactHelper().editContactOnHomePage();
        app.getContactHelper().fillUserFormFromEdit(new UserData("testEditName", "testEditSecondName", "1", "2", "3", "4", "5", "6"));
        app.getContactHelper().submitEditform();
        app.getNavigationHelper().navigateToHomePage();
        app.logout();
    }
}
