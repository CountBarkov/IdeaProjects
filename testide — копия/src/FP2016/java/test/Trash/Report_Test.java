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

public class Report_Test {

    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private StringBuffer pausa = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void Report_Test() throws Exception {

        driver.get("http://stage-registration.23traders.com/reports/deposit_group_behavior/");
        //driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        //driver.findElement(By.id("UserPassword")).click();
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.cssSelector("#submit")).click();


        //WebElement button = driver.findElement(By.name("submit"));
        //button.click();
        //driver.findElement(By.cssSelector("div.submit")).click();
        //driver.findElement(By.cssSelector(".submit")).click();
        //driver.findElement(By.name("submit")).click();
        //driver.findElement(By.className("submit")).click();





        Thread.sleep(7000);

        assertTrue("deposit_group_behavior: Test cannot find element",isElementPresent(By.name("Period")));

        Thread.sleep(7000);

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

