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
public class LeadsAnalysis {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void LeadsAnalysis() throws Exception {
        driver.get("http://registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://registration.23traders.com/reports/leads_analysis/");

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Leads Analysis:";
        System.out.println(se);
        String s1 = driver.findElement(By.id("left-side")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.className("tableFloatingHeaderOriginal")).getText();
        System.out.println(s2);
        String s4 = driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody")).getText();
        System.out.println(s4);
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

