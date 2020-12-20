package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverType;

public class DynamicControlsTest {
    private DriverManager driverManager;
    private WebDriver driver;
    private DynamicControlsPage dynamicControlsPage;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void checkboxTest() {
        dynamicControlsPage = new DynamicControlsPage(driver);

        Assert.assertTrue(dynamicControlsPage.findCheckbox());

        dynamicControlsPage.clickRemoveButton();
    }

    @Test
    public void inputTest() {
        dynamicControlsPage = new DynamicControlsPage(driver);

        Assert.assertTrue(dynamicControlsPage.isInputDisabled());

        dynamicControlsPage.clickEnableFieldButton();

        Assert.assertTrue(dynamicControlsPage.isInputDisabled());
    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }
}
