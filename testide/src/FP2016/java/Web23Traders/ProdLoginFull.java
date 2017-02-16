package Web23Traders;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by Pavel on 04.04.16.
 */
public class ProdLoginFull {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void ProdLoginTest() throws Exception {
        driver.get("https://www.23traders.com/en/");
        driver.findElement(By.id("user_login")).sendKeys("pavel@23traders.com");
        driver.findElement(By.id("user_pass")).sendKeys("qwertysun");
        driver.findElement(By.id("wp-submit")).click();

        Thread.sleep(20000);

        driver.findElement(By.xpath("/html/body/header/div[2]/section/div/div[2]/div[1]/span/span")).click();
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div/div[2]/div[1]/span/ul/li[2]/div/div[2]/a")).click();

        Thread.sleep(3000);

        driver.close();
    }
}

