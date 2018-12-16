package addresses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewAddress extends ParentTest {

    String firstName = "Kate";
    String lastName = "Maruk";
    String phoneNumber = "+380969476125";


    @Test
    public void addNewAddress(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.deleteAddressUntilPresent(lastName, firstName);
        homePage.clickOnAddNewLink();
        contactEditorPage.checkUrl();
        contactEditorPage.enterFirstName(firstName);
        contactEditorPage.enterLastName(lastName);
        contactEditorPage.enterPhoneNuumber(phoneNumber);
        contactEditorPage.clickOnEnterButton();

        checkExpectedResult("New Address was not created", homePage.isAddressDisplayed(lastName));
    }

    @After
    public void deletingAddress(){
        homePage.deleteAddressUntilPresent(lastName, firstName);

    }
}
