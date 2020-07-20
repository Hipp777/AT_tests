package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by 1 on 22.06.2020.
 */
public class TestDeleteContact extends TestBase {
    @Test
    public void deleteContact() {
        int after;

        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
        }
        app.getNavigationHelper().navigateToHomePage();
        int before = app.getContactHelper().getContactCount();
            app.getContactHelper().selectContact(0);
            app.getContactHelper().deleteContact();
            app.getNavigationHelper().navigateToHomePage();
            after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before-1);
            app.logout();
        }
    }

