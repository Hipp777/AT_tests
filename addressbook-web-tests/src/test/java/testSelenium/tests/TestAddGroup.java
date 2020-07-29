package testSelenium.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import testSelenium.model.GroupData;
import testSelenium.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestAddGroup extends TestBase {

    @Test
    public void testFirst() throws Exception {
        app.group().goToGroupsPage();

       Groups listBefore = app.group().all();
        app.group().startGroupCreation();
        GroupData group = new GroupData().withName("Test group 2").withHeader("Logo test").withFooter("Footer test");
        app.group().fillGroupForm(group);
        app.group().submitGroupForm();
        app.group().goToGroupsPage();

        Groups listAfter = app.group().all();
        assertThat(listAfter.size(),equalTo(listBefore.size() + 1) );
       // Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getId(),g2.getId());

       // Assert.assertEquals(listBefore,listAfter);
        assertThat(listAfter, equalTo(
                listBefore.withAdded(group.withId(listAfter.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}

