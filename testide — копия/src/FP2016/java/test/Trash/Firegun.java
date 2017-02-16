package test.Trash;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class Firegun {

    private Selenium selenium;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private StringBuffer pausa = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://stage-registration.23traders.com/reports/deposit_group_behavior/");
        selenium.start();
        driver = new FirefoxDriver();
    }

    @Test
    public void Firegun() throws Exception {
        selenium.open("http://stage-registration.23traders.com/reports/deposit_group_behavior/");

        selenium.waitForPageToLoad("10000");

        selenium.type("id=name", "Timur_admin");
        selenium.type("id=UserPassword", "Tg123456");
        selenium.click("class=form-control btn btn-primary");
        selenium.waitForPageToLoad("20000");

        assertTrue("Deposit_group_behavior: Test cannot find element", isElementPresent(By.name("Period")));

        String se = "23Traders:";
        System.out.print(se);
        String sf = " Success Report_Test";
        System.out.println(sf);

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



