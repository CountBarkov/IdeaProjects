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
public class ExposureReportpopup {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void ExposureReport() throws Exception {
        driver.get("http://registration.23traders.com/reports/exposure/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(12000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form")).click();

        try {
            Thread.sleep(12000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.findElement(By.xpath("//*[@id=\"right-side\"]/div[1]/div/div/table/tbody/tr[1]/td[2]/a")).click();

        try {
            Thread.sleep(12000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Exposure Report:";
        System.out.println(se);
        String s1 = driver.findElement(By.xpath("//*[@id=\"data-table_wrapper\"]")).getText();
        System.out.println(s1);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

