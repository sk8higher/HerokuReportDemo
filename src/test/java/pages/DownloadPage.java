package pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class DownloadPage {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='content']/div/a[2]")
    private WebElement downloadLink;

    public DownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void download() throws IOException {
        String fileLink = downloadLink.getAttribute("href");

        File fileToSave = new File("src/test/resources/text.txt");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileLink);
        HttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());

        copyInputStreamToFile(response.getEntity().getContent(), fileToSave);
    }

    public boolean checkIfDownloaded() {
        File f = new File("src/test/resources/text.txt");
        return f.exists();
    }
}
