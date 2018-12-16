package groups;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewGroup extends ParentTest {

    String groupName = "MarukGroup";
    String groupHeaderr = "MarukHeader";
    String groupFooterr = "MarukFooter";

    @Test
    public void addNewGroup(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnGroupsLink();
        groupPage.checkUrl();
        //groupPage.checkAndDeleteGroup(groupName);
        groupPage.deleteGroupUntilPresent(groupName);
        groupPage.clickOnNewGroupButton();
        editGroupPage.enterGroupName(groupName);
        editGroupPage.enterGroupHeader(groupHeaderr);
        editGroupPage.enterGroupFooter(groupFooterr);
        editGroupPage.clickOnEnterInfoButton();
        groupPage.clickOnLinkGroupPage();

        Assert.assertTrue("New group was not created", groupPage.groupIsDisplayedInList(groupName));

    }

    @After
    public void groupDeleting(){

        groupPage.deleteGroupUntilPresent(groupName);
    }
}


