package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFramePage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[@id='mce_0_ifr']")
    private WebElement editor;

    @FindBy(xpath = "//*[@id='tinymce']/p")
    private WebElement editorText;

    public IFramePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getEditorText() {
        wait = new WebDriverWait(driver, 3);
        driver.switchTo().frame(editor);
        return editorText.getText();
    }
}
