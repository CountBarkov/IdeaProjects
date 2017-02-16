package Web23Traders;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel on 04.04.16.
 */
public class ProdRegEnFull {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    @Test
    public void ProdRegEnFull() throws Exception {
        driver.get("https://www.23traders.com/en/registration/");
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        String s1 = "testregprodfull";
        String s2 = "@mail.org";
        long timestamp = System.currentTimeMillis() / 1000;
        String s = s1 + timestamp + s2;
        driver.findElement(By.id("email")).sendKeys(s);
        driver.findElement(By.id("password")).sendKeys("qwerty");
        driver.findElement(By.id("phone")).sendKeys("234324324");
        new Select(driver.findElement(By.id("currency"))).selectByVisibleText("USD");
        driver.findElement(By.cssSelector("section > #wp-submit")).click();
        driver.findElement(By.id("agree")).click();
        driver.findElement(By.cssSelector("section > #wp-submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.findElement(By.id("wraper-popup")).click();
        driver.findElement(By.xpath("//*[@id=\"wraper-popup\"]/div[2]/span[2]/section/div/div/div/section/footer/div/span")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String s12 = driver.findElement(By.id("userBalance")).getText();
        System.out.println(s12);

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