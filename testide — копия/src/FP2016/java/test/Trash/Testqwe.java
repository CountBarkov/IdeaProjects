//Это тест на сафари драйвере

package test.Trash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Testqwe {

    private WebDriver driver = null;
    private StringBuffer pausa = new StringBuffer();
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void createDriver() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void Testqwe() {
        driver.get("http://stage-registration.23traders.com/reports/deposit_group_behavior/");

        //Thread.sleep(7000);

        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).click();
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");

        driver.findElement(By.cssSelector("div.submit")).click();
        driver.findElement(By.cssSelector(".submit")).click();
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.className("submit")).click();

        //Thread.sleep(7000);

        assertTrue("deposit_group_behavior: Test cannot find element", isElementPresent(By.name("Period")));
        //assertTrue("deposit_group_behavior: Test cannot find element", isElementPresent(By.name("submit")));

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[9]/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[9]/ul/li/a")).click();

        String se = "Deposit_group_behavior:";
        System.out.println(se);
        String sf = "Success Report_Test";
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