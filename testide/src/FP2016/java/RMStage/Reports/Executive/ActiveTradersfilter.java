package RMStage.Reports.Executive;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class ActiveTradersfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void ActiveTraders() throws Exception {
        driver.get("http://stage-registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://stage-registration.23traders.com/reports/active_traders/");

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Change month
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[1]")).clear();
        String date = "2016-10-01";
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/div/input[1]")).sendKeys(date);

        //Click button
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[2]/input")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Active Traders:";
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

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.close();
    }
}

