package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IFramePage;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverType;

public class IFrameTest {
    private DriverManager driverManager;
    private WebDriver driver;
    private IFramePage iFramePage;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void textEqualsTest() {
        iFramePage = new IFramePage(driver);
        Assert.assertEquals(iFramePage.getEditorText(), "Your content goes here.");
    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }
}
