package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkWithElements {
    WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());

    public WorkWithElements(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void enterTextIntoElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into Login field");

        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    public  void clickOnElement(WebElement element){
        try{
            element.click();

        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }
    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();

        }catch (Exception w){
            return false;

        }
    }

    public  boolean isElementDisplayed(By by){
        try{
         return isElementDisplayed(webDriver.findElement(by));
    }catch (Exception e){
        return false;
        }
    }


}