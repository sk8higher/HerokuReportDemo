/*
 * TODO: make drivermanagerfactory work here
 * test is broken
 */

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DownloadPage;

import java.io.IOException;
import java.util.HashMap;

public class DownloadTest {
    private WebDriver driver;
    private DownloadPage page;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("~/IdeaProjects/Lecture10/src/test/resources"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-debugging-port=9222", "--headless", "--disable-gpu");
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);

        driver.get("http://the-internet.herokuapp.com/download");
    }

    @Test(enabled = false)
    public void downloadFile() throws IOException {
        page = new DownloadPage(driver);
        page.download();
        Assert.assertTrue(page.checkIfDownloaded());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
