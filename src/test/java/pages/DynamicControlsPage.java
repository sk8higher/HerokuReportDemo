package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[@id='checkbox']/input")
    private WebElement checkbox;

    @FindBy(xpath = "//*[@id='checkbox-example']/button")
    private WebElement removeCheckboxButton;

    @FindBy(tagName = "input")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id='input-example']/button")
    private WebElement inputEnableOrDisableButton;

    public DynamicControlsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean findCheckbox() {
        return checkbox.isDisplayed();
    }

    public void clickRemoveButton() {
        removeCheckboxButton.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
    }

    public boolean isInputDisabled() {
        return inputField.isEnabled();
    }

    public void clickEnableFieldButton() {
        inputEnableOrDisableButton.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
    }
}
