package testSelenium.tests;

import org.testng.annotations.Test;

/**
 * Created by 1 on 22.06.2020.
 */
public class DeleteContactTest3 extends TestBase {
    @Test
    public void deleteContact() {
        app.getContactHelper().selectSecondContact();
        app.getContactHelper().deleteContact();

        app.getNavigationHelper().navigateToHomePage();
        app.logout();
    }
}
