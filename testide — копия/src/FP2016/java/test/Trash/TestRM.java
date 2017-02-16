package test.Trash;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pavel
 */
public class TestRM {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void TestRM() throws Exception {
        driver.get("http://stage-registration.23traders.com/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(5000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        driver.get("http://stage-registration.23traders.com/reports/deposit_withdrawal/");

        try {
            Thread.sleep(5000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        try {
            assertEquals("Date", driver.findElement(By.name("Date")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

}
/*    @After
    public void tearDown ()throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement((By.name("Open Positions")));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}



/*

        driver.close();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}


        String se = "Deposit - Withdrawal:";
        System.out.println(se);
        String s = driver.findElement(By.name("Open Positions")).getText();
        System.out.println(s + " " + "= Total's correct test");
        String s1 = driver.findElement(By.name("Date")).getText();
        System.out.println(s1 + " " + "= Table's correct test");
        String sf = "                                                    ";
        System.out.println(sf);

         isElementPresent(By.name("Date"));
        isAlertPresent();
        closeAlertAndGetItsText();


*/





