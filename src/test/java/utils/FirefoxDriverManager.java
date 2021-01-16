package utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {
    private GeckoDriverService ffService;

    @Override
    public void startService() {
        if (null == ffService) {
            try {
                ffService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("src/test/resources/geckodriver"))
                        .usingAnyFreePort()
                        .build();
                ffService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != ffService && ffService.isRunning()) {
            ffService.stop();
        }
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless", "--disable-gpu");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(ffService, capabilities);
    }
}
