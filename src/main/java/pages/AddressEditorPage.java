package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressEditorPage extends ParentPage {

    @FindBy(xpath = ".//input[@name = 'firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = ".//input[@name = 'lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = ".//input[@name = 'mobile']")
    WebElement phoneInput;

    @FindBy(xpath = ".//input[@value = 'Enter']")
    WebElement enterButton;

    public AddressEditorPage(WebDriver webDriver) {
        super(webDriver, "/edit.php");
    }


    public void enterFirstName(String firstName) {
        workWithElements.enterTextIntoElement(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        workWithElements.enterTextIntoElement(lastNameInput, lastName);

    }

    public void enterPhoneNuumber(String phoneNumber) {
        workWithElements.enterTextIntoElement(phoneInput, phoneNumber);
    }

    public void clickOnEnterButton() {
        workWithElements.clickOnElement(enterButton);
    }
}
