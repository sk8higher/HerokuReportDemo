package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
    public WebDriver driver;

    private Actions actions;
    private Alert alert;

    @FindBy(id = "hot-spot")
    private WebElement triggerBox;

    public ContextMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnBox() {
        actions = new Actions(driver);
        actions.contextClick(triggerBox).perform();
    }

    public String checkAlert() {
        alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void closeAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }
}
