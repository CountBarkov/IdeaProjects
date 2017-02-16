package Oldreports;

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
public class DepositGroupBehavior {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();
    private StringBuffer verificationErrors = new StringBuffer();



    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void DepositGroupBehavior() throws Exception {
        driver.get("http://stage-registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://stage-registration.23traders.com/reports/deposit_group_behavior/");
        assertTrue("Deposit Group Behavior: Test cannot find element", isElementPresent(By.name("Period")));


        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "Deposit Group Behavior:";
        System.out.println(se);
        String s1 = driver.findElement(By.name("Period")).getText();
        System.out.println(s1);
        String sf = "---------------------------------------";
        System.out.println(sf);

        try {
            Thread.sleep(3000);
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

