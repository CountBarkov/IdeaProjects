package RMStage.Reports.Conversion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class LeadsStatusfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void LeadsStatus() throws Exception {
        driver.get("http://stage-registration.23traders.com/reports/leads_status/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Select filter Deposit
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/select/option[2]")).click();

        //Change Since date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).clear();
        String date1 = "2016-09-01";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).sendKeys(date1);

        //Change Before date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).clear();
        String date2 = "2016-10-31";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).sendKeys(date2);

        //Select Campaign
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[55]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[56]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[57]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[58]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[59]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[60]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[61]/a/label")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/div/ul/li[62]/a/label")).click();
        //Select Country
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[4]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[4]/div/ul/li[26]/a/label")).click();

        //Select Group By Country
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[5]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[5]/select/option[2]")).click();

        //Click button
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[6]/input")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Leads Status:";
        System.out.println(se);
        String s1 = driver.findElement(By.id("left-side")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.className("tableFloatingHeaderOriginal")).getText();
        System.out.println(s2);
        String s3 = driver.findElement(By.xpath("//*[@id=\"summary-row\"]")).getText();
        System.out.println(s3);
        String s4 = driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody")).getText();
        System.out.println(s4);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

