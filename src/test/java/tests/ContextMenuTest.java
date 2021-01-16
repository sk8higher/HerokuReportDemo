package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverType;

public class ContextMenuTest {
    private DriverManager driverManager;
    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test(description = "Right click on context menu and check what is the text in the alert")
    public void checkAlertContains() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.clickOnBox();

        Assert.assertEquals(contextMenuPage.checkAlert(), "You selected a context menu");

        contextMenuPage.closeAlert();
    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }
}
