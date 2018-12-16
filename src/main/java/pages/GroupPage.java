package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupPage extends ParentPage {

    GroupPage groupPage;

    @FindBy(xpath = ".//*[@id = 'content']/form/input[1]")
    WebElement newGroupButton;

    @FindBy(xpath = ".//div[@id='content']/form/input[2]")
    WebElement deleteGroupButton;

    @FindBy(xpath = ".//input[@name = 'edit']")
    WebElement  editGroupButton;

    @FindBy(xpath = ".//i/a[@href = 'group.php']")
    WebElement groupPageLink;


    public GroupPage(WebDriver webDriver) {
        super(webDriver, "/group.php");
    }

//    public void checkAndDeleteGroup(String groupName) {
//        if (groupNameSpan.size()>0){
//            for (WebElement line: groupNameSpan) {
//
//            }
//        }

    public void deleteGroupUntilPresent(String groupName) {
            int counter = 0;

            while (groupIsDisplayedInList(groupName)) {
                selectCheckboxWithGroupName(groupName);
                clickOnButtonDeleteGroup();
                clickOnLinkGroupPage();
                counter++;

                if (counter > 100) {
                    Assert.fail("Group deleting is not working!!!");
                }
            }
    }

    public void clickOnLinkGroupPage() {

        workWithElements.clickOnElement(groupPageLink);
    }


    public void selectCheckboxWithGroupName(String groupName) {
        workWithElements.clickOnElement(getCheckBoxWithName(groupName));
        }

    private WebElement getCheckBoxWithName(String groupName) {

        return webDriver.findElement(By.xpath(".//input[@type = 'checkbox'][@title = 'Select (" + groupName + ")']"));

    }

    private void clickOnButtonDeleteGroup() {

        workWithElements.clickOnElement(deleteGroupButton);
    }

    public boolean groupIsDisplayedInList(String groupName) {
         return workWithElements.isElementDisplayed(By.xpath(".//*[text() = '" + groupName + "']"));

    }

    public void clickOnNewGroupButton() {
        workWithElements.clickOnElement(newGroupButton);
    }

    public void clickOnEditGroupButton() {

        workWithElements.clickOnElement(editGroupButton);
    }

    public void createGroupIfNotExist(String groupName) {

        if (!groupIsDisplayedInList(groupName)){
            createGroupForEditing(groupName);
        }
    }

    public void createGroupForEditing(String groupName){
        clickOnNewGroupButton();
        EditGroupPage editGroupPage = new EditGroupPage(webDriver);
        editGroupPage.enterGroupName(groupName);
        editGroupPage.clickOnEnterInfoButton();
        editGroupPage.clickOnGroupsLink();

    }

}
