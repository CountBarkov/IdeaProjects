package RMProd.Reports.Retention;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class Lightning {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void Lightning() throws Exception {
        driver.get("http://registration.23traders.com/lightning/set_employee/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.findElement(By.className("btn-primary")).click();

        try {
            Thread.sleep(60000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Lightning:";
        System.out.println(se);
        String s = driver.findElement(By.cssSelector("[table-name='table_agent_summary']")).getText();
        System.out.println(s);
        String s1 = driver.findElement(By.cssSelector("[table-name='table_new_clients']")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.cssSelector("[table-name='table_balances']")).getText();
        System.out.println(s2);
        String s3 = driver.findElement(By.cssSelector("[table-name='table_online_clients']")).getText();
        System.out.println(s3);
        String s4 = driver.findElement(By.cssSelector("[table-name='table_no_comments_four_business_days']")).getText();
        System.out.println(s4);
        String s5 = driver.findElement(By.cssSelector("[table-name='table_last_trades']")).getText();
        System.out.println(s5);
        String s6 = driver.findElement(By.cssSelector("[table-name='table_deposits']")).getText();
        System.out.println(s6);
        String s7 = driver.findElement(By.cssSelector("[table-name='table_withdraw_requests']")).getText();
        System.out.println(s7);
        String s8 = driver.findElement(By.cssSelector("[table-name='table_no_trade_four_days']")).getText();
        System.out.println(s8);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

