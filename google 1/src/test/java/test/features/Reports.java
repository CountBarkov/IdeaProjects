package test.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import test.steps.EndUserSteps;


@RunWith(SerenityRunner.class)
public class Reports {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps admin;

    @Issue("#login Stage-Reports")

    @Test
    public void test() {
        //webdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        admin.is_the_report_page();
        admin.fill_login_input("Timur_admin");
        admin.fill_pass("Tg123456");
        admin.click_button();
        admin.should_see_onscreen("Period");
    }

}