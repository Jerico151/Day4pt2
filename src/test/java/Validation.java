import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUP () {
        System.setProperty("webdriver.chrome.driver", "c:\\Users/user/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 100 , 10);
    }
    @AfterTest
    public void quitBrowser () {
        driver.quit();
    }

    @Test
    public void validationTest () {

        driver.get("http://demo.guru99.com/V1/index.php");
        WebElement username = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        WebElement pass = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        WebElement body = driver.findElement(By.cssSelector("body"));

        username.click();
        pass.click();
        body.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message23\"]")));
        WebElement passValidation =  driver.findElement(By.xpath("//*[@id=\"message23\"]"));
        String actualpassValidation = passValidation.getText();
        String expectedpassValidation = "User-ID must not be blank";
        Assert.assertEquals(actualpassValidation, expectedpassValidation);

        username.sendKeys("a");
        pass.sendKeys("a");
        Assert.assertEquals(actualpassValidation, expectedpassValidation);
        System.out.println("Test passed");
    }
}