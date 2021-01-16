package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUploadPage {
    public WebDriver driver;
    public WebDriverWait wait;

    private File file;

    @FindBy(xpath = "//*[@id='file-upload']")
    private WebElement fileChooseButton;

    @FindBy(xpath = "//*[@id='file-submit']")
    private WebElement fileUploadButton;

    public FileUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public FileUploadPage chooseFile() {
        file = new File("src/test/resources/lol.png");
        fileChooseButton.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FileUploadPage uploadFile() {
        fileUploadButton.click();
        return this;
    }

    public String getFilename() {
        wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions
                          .visibilityOfElementLocated(By.xpath("//*[@id='uploaded-files']")))
                          .getText();
    }
}
