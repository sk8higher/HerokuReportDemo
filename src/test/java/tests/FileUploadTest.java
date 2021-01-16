package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import utils.DriverManager;
import utils.DriverManagerFactory;
import utils.DriverType;

public class FileUploadTest {
    private DriverManager driverManager;
    private WebDriver driver;
    private FileUploadPage fileUploadPage;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void uploadAndCheckFilename() {
        fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.chooseFile()
                .uploadFile();

        Assert.assertEquals(fileUploadPage.getFilename(), "lol.png");
    }

    @AfterTest
    public void tearDown() {
        driverManager.quitDriver();
    }
}
