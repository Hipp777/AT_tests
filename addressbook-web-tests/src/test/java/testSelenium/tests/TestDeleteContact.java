package testSelenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by 1 on 22.06.2020.
 */
public class TestDeleteContact extends TestBase {
    @BeforeMethod
    public void ensurePreconditions (){
        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
        }
        app.goTo().homePage();
    }
    @Test
    public void deleteContact() {
        int after;
        int before = app.getContactHelper().getContactCount();
            app.getContactHelper().selectContact(0);
            app.getContactHelper().deleteContact();
            app.goTo().homePage();
            after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before-1);

        }
    }

