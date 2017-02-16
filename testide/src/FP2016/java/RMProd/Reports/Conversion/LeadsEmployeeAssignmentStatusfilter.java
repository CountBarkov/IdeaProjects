package RMProd.Reports.Conversion;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class LeadsEmployeeAssignmentStatusfilter {

    private WebDriver driver;
    private StringBuffer pausa = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void LeadsEmployeeAssignmentStatus() throws Exception {
        driver.get("http://registration.23traders.com/reports/leads_employee_assignment_status/");
        driver.findElement(By.id("name")).sendKeys("Timur_admin");
        driver.findElement(By.id("UserPassword")).sendKeys("Tg123456");
        driver.findElement(By.className("submit")).click();

        try {
            Thread.sleep(3000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        //Select filter Deposit
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[1]/select/option[2]")).click();

        //Change Since date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).click();
        String date1 = "2016-10-04";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[1]")).sendKeys(date1);

        //Change Before date
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).click();
        String date2 = "2016-10-05";
        driver.findElement(By.xpath("//*[@id=\"filter_option_deposit_date\"]/input[2]")).sendKeys(date2);

        //Select Employees
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[3]/select/option[1]")).click();

        //Click button
        driver.findElement(By.xpath("//*[@id=\"left-side\"]/form/table/tbody/tr[2]/td[5]/input")).click();

        try {
            Thread.sleep(30000);
        } catch (Error e) {
            pausa.append(e.toString());
        }

        String se = "FTDLeads:";
        System.out.println(se);
        String s1 = driver.findElement(By.id("left-side")).getText();
        System.out.println(s1);
        String s2 = driver.findElement(By.className("tableFloatingHeaderOriginal")).getText();
        System.out.println(s2);
        String s3 = driver.findElement(By.xpath("//*[@id=\"summary-row\"]")).getText();
        System.out.println(s3);
        String s4 = driver.findElement(By.xpath("//*[@id=\"data-table\"]/tbody")).getText();
        System.out.println(s4);
        String sf = "---------------------------------------";
        System.out.println(sf);

        driver.close();
    }
}

