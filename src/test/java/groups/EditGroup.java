package groups;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class EditGroup extends ParentTest {

    String groupName = "MarukGroup";
    String editedGroupName = "MarukGroup12";

    @Test
    public void editExistGroup() {
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnGroupsLink();
        groupPage.checkUrl();
        groupPage.createGroupIfNotExist(groupName);
        groupPage.selectCheckboxWithGroupName(groupName);
        groupPage.clickOnEditGroupButton();
        editGroupPage.enterEditedGroupName(editedGroupName);
        editGroupPage.clickOnUpdateButton();
        groupPage.clickOnLinkGroupPage();
        groupPage.groupIsDisplayedInList(editedGroupName);

        Assert.assertTrue("Group was not edited!", groupPage.groupIsDisplayedInList(editedGroupName));

    }

    @After
    public void groupDeleting() {
        groupPage.deleteGroupUntilPresent(editedGroupName);

    }
}


