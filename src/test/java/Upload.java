import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Upload {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUP () {
        System.setProperty("webdriver.chrome.driver", "c:\\Users/user/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10 , 0);
    }
    @AfterTest
    public void quitBrowser () {
        driver.quit();
    }
    @Test
    public void uploadFile() {

        driver.get("http://demo.guru99.com/test/upload/");
        WebElement uploadButton = driver.findElement(By.name("uploadfile_0"));
        uploadButton.sendKeys("c:\\Users/user/Desktop/gitava.jpg");

        driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitbutton\"]")));

        driver.findElement(By.xpath("//*[@id=\"submitbutton\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"res\"]/center")));
        WebElement successful = driver.findElement(By.xpath("//*[@id=\"res\"]/center"));
        String expectedCongrats = "1 file\n" +
                "has been successfully uploaded.";
        String actualCongrats = successful.getText();
        Assert.assertEquals(expectedCongrats, actualCongrats);
    }
}