package test.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import test.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class Tr23 {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps admin;

    @Issue("#login 23Traders")

    @Test
    public void test() {
        admin.is_the_google_page();
        admin.fill_search_input("pavel@23traders.com");
        admin.fill_pass("qwertysun");
        admin.click_button();
        // admin.click_button();
        admin.should_see_definition1111("Welcome Quality");
    }

}