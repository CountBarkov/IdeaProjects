package Web23Traders;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by Pavel
 */
public class Balanspresent {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void Balanspresent() throws Exception {
        driver.get("https://www.23traders.com/en/");
        driver.findElement(By.id("user_login")).sendKeys("pavel@23traders.com");
        driver.findElement(By.id("user_pass")).sendKeys("qwertysun");
        driver.findElement(By.id("wp-submit")).click();

        try {
            Thread.sleep(20000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String s = driver.findElement(By.id("userBalance")).getText();
        System.out.println(s);

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.findElement(By.xpath("/html/body/header/div[2]/section/div/div[2]/div[1]/span/span")).click();
        driver.findElement(By.xpath("/html/body/header/div[2]/section/div/div[2]/div[1]/span/ul/li[2]/div/div[2]/a")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.close();
    }
}
