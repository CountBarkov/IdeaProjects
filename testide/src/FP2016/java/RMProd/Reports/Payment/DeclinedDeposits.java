package RMProd.Reports.Payment;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class DeclinedDeposits {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void DeclinedDeposits() throws Exception {
        driver.get("http://registration.23traders.com/reports/declined_deposits/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Declined Deposits:";
        System.out.println(se);
        String s1 = driver.findElement(By.xpath("//*[@id=\"left-side\"]/form")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.xpath("//*[@id=\"stat-table\"]")).getText();
        System.out.println(s2);
        String s3 = driver.findElement(By.xpath("//*[@id=\"right-side\"]")).getText();
        System.out.println(s3);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

