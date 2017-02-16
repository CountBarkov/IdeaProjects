package test.steps;

import net.thucydides.core.steps.ScenarioSteps;
import test.pages.LoginStageReports;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EndUserSteps extends ScenarioSteps {

    LoginStageReports test1;

    public void is_the_report_page() {
        test1.open();
    }

    public void fill_login_input(String test) {
        test1.fill_input(test);
    }

    public void fill_pass(String s1) { test1.fill_password(s1); }

    public void click_button() {
        test1.ckick_button();
    }

    public void should_see_onscreen(String s) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test1.getText());
        assertThat(test1.getText(), containsString(s));
    }

}