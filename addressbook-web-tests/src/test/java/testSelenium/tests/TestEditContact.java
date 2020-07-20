package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSelenium.model.UserData;


public class TestEditContact extends TestBase {
    @Test
    public void editFirstContact() {

        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
        }
        app.getNavigationHelper().navigateToHomePage();
        int after;
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().editContactOnHomePage();
        app.getContactHelper().fillUserFormFromEdit(new UserData("testEditName22", "testEditSecondName", "1", "2", "3", "4", "5", "6"));
        app.getContactHelper().submitEditform();
        app.getNavigationHelper().navigateToHomePage();
        after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
        app.logout();
    }


}

