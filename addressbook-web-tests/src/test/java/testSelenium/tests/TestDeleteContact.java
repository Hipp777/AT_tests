package testSelenium.tests;

import org.testng.annotations.Test;
import testSelenium.model.UserData;

/**
 * Created by 1 on 22.06.2020.
 */
public class TestDeleteContact extends TestBase {
    @Test
    public void deleteContact() {
        if (!app.getContactHelper().checkFirstContact()) {
            app.getContactHelper().addContact();
            app.getNavigationHelper().navigateToHomePage();

            app.getContactHelper().selectfirstContactOnHomePage();
            app.getContactHelper().deleteContact();
            app.getNavigationHelper().navigateToHomePage();
            app.logout();
        } else {
            app.getContactHelper().selectfirstContactOnHomePage();
            app.getContactHelper().deleteContact();
            app.getNavigationHelper().navigateToHomePage();
            app.logout();
        }
    }
}
