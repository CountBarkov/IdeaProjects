package RMStage.Reports.Payment;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class DeclinedDepositsfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void DeclinedDeposits() throws Exception {
        driver.get("http://stage-registration.23traders.com/reports/declined_deposits/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Select filter By
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/select/option[2]")).click();

        //Change Since date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).click();
        String date1 = "2016-10-01";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).sendKeys(date1);

        //Change Before date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).click();
        String date2 = "2016-10-31";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).sendKeys(date2);

        //Select FTD/RET
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/select")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/select/option[2]")).click();

        //Click button
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[4]/input")).click();

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

