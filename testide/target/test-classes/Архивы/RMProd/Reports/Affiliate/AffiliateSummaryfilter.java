package RMStage.Reports.Affiliate;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class AffiliateSummaryfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void AffiliateSummary() throws Exception {
        driver.get("http://registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://registration.23traders.com/reports/affiliate_summary/");

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Change Since date
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[1]")).clear();
        String date1 = "2016-11-01";
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[1]")).sendKeys(date1);

        //Change Before date
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[2]")).clear();
        String date2 = "2016-11-09";
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[2]")).sendKeys(date2);

        //Change Since date
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/div/input[1]")).click();
        String date3 = "2016-11-01";
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/div/input[1]")).sendKeys(date3);

        //Change Before date
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/div/input[2]")).click();
        String date4 = "2016-11-09";
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/div/input[2]")).sendKeys(date4);

        //Click button
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/input")).click();

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Affiliate Summary:";
        System.out.println(se);
        String s1 = driver.findElement(By.xpath("//*[@id=\"left-side\"]")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.xpath("//*[@id=\"right-side\"]")).getText();
        System.out.println(s2);
        String sf = "---------------------------------------";
        System.out.println(sf);

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.close();
    }
}

