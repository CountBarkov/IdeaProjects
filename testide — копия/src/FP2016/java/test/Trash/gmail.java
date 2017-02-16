package test.Trash;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Pavel on 8/29/16.
 */
public class gmail {

        private WebDriver driver;
        private StringBuffer pausa = new StringBuffer();
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void gmail() throws Exception {
            driver.get("https://mail.google.com/");
            //driver.findElement(By.className("signin-button")).click();

            driver.findElement(By.id("Email")).sendKeys("pavel.shyshkov@gmail.com");
            driver.findElement(By.id("next")).click();

            driver.findElement(By.id("Passwd")).sendKeys("dreamer2404");
            driver.findElement(By.id("signIn")).click();

            try {
                Thread.sleep(5000);
            } catch (Error e) {
                pausa.append(e.toString());
            }

            driver.findElement(By.className("z0")).click();
            driver.findElement(By.className("vO")).sendKeys("pavel@23traders.com");
            driver.findElement(By.className("aoT")).sendKeys("TestResults");

            try {
                Thread.sleep(5000);
            } catch (Error e) {
                pausa.append(e.toString());
            }

            driver.findElement(By.id(":or")).click(); //google drive

            try {
                Thread.sleep(5000);
            } catch (Error e) {
                pausa.append(e.toString());
            }

            driver.findElement(By.className("Cj-Ek-Lj-O-jo-ko")).click(); //file
            driver.findElement(By.id("picker:ap:0")).click(); //add file
            driver.findElement(By.id(":ml")).click(); //send file

            try {
                Thread.sleep(5000);
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


