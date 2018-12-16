package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name = 'user']")
    WebElement inputLogin;

    @FindBy(xpath = ".//input[@type = 'password']")
    WebElement inputPassword;

    @FindBy(xpath = ".//input[@value = 'Login']")
    WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {
        super(webDriver,"/");
    }


    public void openLoginPage(){
        try{
            webDriver.get("http://localhost/addressbook");
            logger.info("Open Login Page");

        }catch(Exception e){
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");

        }

    }
    public void enterLogin(String login) {
       workWithElements.enterTextIntoElement(inputLogin, login);

    }

    public void enterPassword(String passWord) {
        workWithElements.enterTextIntoElement(inputPassword, passWord);

    }

    public void clickOnButtonLogin() {
        workWithElements.clickOnElement(buttonLogin);
    }


    public void logInWithCredentials(String login, String passWord){
            openLoginPage();
            enterLogin(login);
            enterPassword(passWord);
            clickOnButtonLogin();
    }

    public void validLogInWithCredentials(){
        logInWithCredentials("admin", "secret");
        HomePage homePage = new HomePage(webDriver);
        homePage.isLogoutLinkDisplayed();

    }

    public boolean isButtonLogInDisplayed() {
        return workWithElements.isElementDisplayed(buttonLogin);
    }


}


