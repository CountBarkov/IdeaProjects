package test.Trash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by Pavel
 */
public class First {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void First() throws Exception {
        driver.get("http://registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://registration.23traders.com/reports/deposit_withdrawal/");
        assertTrue("Prod:Deposit-Withdrawal: Test cannot find element", isElementPresent(By.name("Date")));


        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Prod:Deposit-Withdrawal:";
        System.out.println(se);
        String s = driver.findElement(By.name("Open Positions")).getText();
        System.out.println(s);
        String s1 = driver.findElement(By.name("Date")).getText();
        System.out.println(s1);
        String sf = "---------------------------------------";
        System.out.println(sf);

        try {
            Thread.sleep(7000);
        } catch (Error e) {
            pausa.append(e.toString());
        }
    }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

