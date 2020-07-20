package testSelenium.tests;

import org.testng.annotations.Test;
import testSelenium.model.UserData;


public class TestEditContact extends TestBase {
    @Test
    public void editFirstContact() {
        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
            app.getNavigationHelper().navigateToHomePage();

            app.getContactHelper().selectfirstContactOnHomePage();
            app.getContactHelper().editContactOnHomePage();
            app.getContactHelper().fillUserFormFromEdit(new UserData("testEditName", "testEditSecondName", "1", "2", "3", "4", "5", "6"));
            app.getContactHelper().submitEditform();
            app.getNavigationHelper().navigateToHomePage();
            app.logout();
        } else {
            app.getContactHelper().selectfirstContactOnHomePage();
            app.getContactHelper().editContactOnHomePage();
            app.getContactHelper().fillUserFormFromEdit(new UserData("testEditName", "testEditSecondName", "1", "2", "3", "4", "5", "6"));
            app.getContactHelper().submitEditform();
            app.getNavigationHelper().navigateToHomePage();
            app.logout();
        }


    }
}
