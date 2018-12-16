package logOut;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LogOut extends ParentTest {

    @Test
    public void logOut(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnLogOutLink();

        Assert.assertTrue("Button 'Login' is not present on page",loginPage.isButtonLogInDisplayed());
    }
}
