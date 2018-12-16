package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[contains(text(), 'Logout')]")
    WebElement linkLogOut;

    @FindBy(xpath = ".//a[@href = 'group.php']")
    WebElement groupsLink;

    @FindBy(xpath = ".//a[@href = 'edit.php']")
    WebElement addNewLink;


    public HomePage(WebDriver webDriver) {

        super(webDriver, "/");
    }

    public boolean isLogoutLinkDisplayed() {

        return workWithElements.isElementDisplayed(linkLogOut);
    }

    public void clickOnGroupsLink(){

        workWithElements.clickOnElement(groupsLink);
    }

    public void clickOnLogOutLink(){
        workWithElements.clickOnElement(linkLogOut);
        logger.info("Clicking on 'Logout' link");

    }


    public void clickOnAddNewLink() {
        workWithElements.clickOnElement(addNewLink);
    }

    public boolean isAddressDisplayed() {

        return workWithElements.isElementDisplayed(By.xpath(""));
    }
}
