package addresses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentTest.ParentTest;

public class AddNewAddress extends ParentTest {

    String firstName = "KateName";
    String lastName = "MarukName";
    String phoneNumber = "+380969476125";


    @Test
    public void addNewAddress(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.deleteContactUntilPresent(phoneNumber);
        homePage.clickOnAddNewLink();
        contactEditorPage.checkUrl();
        contactEditorPage.enterFirstName(firstName);
        contactEditorPage.enterLastName(lastName);
        contactEditorPage.enterPhoneNuumber(phoneNumber);
        contactEditorPage.clickOnEnterButton();

        Assert.assertTrue("", homePage.isAddressDisplayed());
    }

    @After
    public void deletingAddress(){
        homePage.deleteContactUntilPresent(phoneNumber);

    }
}
