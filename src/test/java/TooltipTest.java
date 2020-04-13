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

public class TooltipTest  {
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
    public void tooltipTest () {
        //open site and find icon with tooltip
        driver.get("http://demo.guru99.com/test/social-icon.html");
        WebElement rssTooltip = driver.findElement(By.xpath("//*[@id=\"top-bar\"]/div/div/div[2]/div/a[6]"));
        //find tooltip and compare with expected tooltip
        String expectedTooltip = "Rss";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-bar\"]/div/div/div[2]/div/a[6]")));
        String actualTooltip = rssTooltip.getAttribute("title");
        Assert.assertEquals(actualTooltip, expectedTooltip);
    }
}
