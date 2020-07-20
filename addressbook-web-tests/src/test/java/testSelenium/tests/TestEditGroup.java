package testSelenium.tests;

import org.testng.annotations.Test;
import testSelenium.model.GroupData;

/**
 * Created by 1 on 23.06.2020.
 */
public class TestEditGroup extends TestBase {
    @Test
    public void editFirstGroup() {

        if (app.getGroupHelper().checkFirstGroup()) {
            app.getGroupHelper().goToGroupsPage();
            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().startEditGroup();
            app.getGroupHelper().fillGroupForm(new GroupData("testEdit111", "Test edit 2", "Testedit3"));
            app.getGroupHelper().submitEditGroup();
            app.getGroupHelper().goToGroupsPage();
            app.logout();
        } else {
            app.getGroupHelper().addGroup();

            app.getGroupHelper().goToGroupsPage();
            app.getGroupHelper().selectFirstGroup();
            app.getGroupHelper().startEditGroup();
            app.getGroupHelper().fillGroupForm(new GroupData("testEdit222", "Test edit 2", "Testedit3"));
            app.getGroupHelper().submitEditGroup();
            app.getGroupHelper().goToGroupsPage();
            app.logout();

        }
    }

}

