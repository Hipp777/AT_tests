package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testSelenium.model.UserData;


public class TestEditContact extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
        }
        app.goTo().homePage();
    }

    @Test
    public void editFirstContact() {

        int after;
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().editContactOnHomePage();
        app.getContactHelper().fillUserFormFromEdit(new UserData("testEditName22", "testEditSecondName", "1", "2", "3", "4", "5", "6"));
        app.getContactHelper().submitEditform();
        app.goTo().homePage();
        after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);

    }


}

