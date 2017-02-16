package RMStage.Reports.Blitz;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class BlitzConversion {

        private WebDriver driver;
        private StringBuffer pausa = new StringBuffer();


        @Before
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }


        @Test
        public void ConversionBlitz() throws Exception {
            driver.get("http://stage-registration.23traders.com/blitz/conversion");
            driver.findElement(By.id("name")).sendKeys("Timur_admin");
            driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
            driver.findElement(By.className("submit")).click();

            try {
                Thread.sleep(3000);
            } catch (Error e) {
                pausa.append(e.toString());
            }

            String se = "Conversion-Blitz:";
            System.out.println(se);
            String s = driver.findElement(By.xpath("//*[@id=\"data-container\"]/table")).getText();
            System.out.println(s);
            String sf = "---------------------------------------";
            System.out.println(sf);

            driver.close();
        }
    }
