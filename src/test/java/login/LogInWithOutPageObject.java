package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LogInWithOutPageObject {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe"); //
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

    @Test
    public void validLogIn(){

        webDriver.get("http://localhost/addressbook");

        webDriver.findElement(By.xpath(".//input[@name = 'user']")).clear();
        webDriver.findElement(By.xpath(".//input[@name = 'user']")).sendKeys("admin");

        webDriver.findElement(By.xpath(".//input[@type = 'password']")).clear();
        webDriver.findElement(By.xpath(".//input[@type = 'password']")).sendKeys("secret");

        webDriver.findElement(By.xpath(".//input[@value = 'Login']")).click();

        Assert.assertTrue("Link 'Logout' is not present on page", isLogoutPresent());

    }

    @After
    public void tearDown(){
        webDriver.quit();
    }


    public boolean isLogoutPresent(){
        try{
            return webDriver.findElement(By.xpath(".//a[contains(text(), 'Logout')]")).isDisplayed();

        }catch (Exception w){
            return false;

        }
    }
}
