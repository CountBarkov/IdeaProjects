package RMProd.Reports.Executive;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class FTDRetentionBreakdownfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void FTDRetentionBreakdown() throws Exception {
        driver.get("http://registration.23traders.com/reports/ftd_retention_breakdown/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Change month
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/span")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/table/tbody/tr/td/span[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/input")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "FTD-Retention Breakdown:";
        System.out.println(se);
        String s1 = driver.findElement(By.xpath("//*[@id=\"left-side\"]/form")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.id("data-table")).getText();
        System.out.println(s2);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

