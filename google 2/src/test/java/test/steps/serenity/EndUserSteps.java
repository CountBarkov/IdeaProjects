package test.steps.serenity;

import net.thucydides.core.steps.ScenarioSteps;
import test.pages.login23tr;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    login23tr test1;

    public void is_the_google_page() {
        test1.open();
    }

    public void fill_search_input(String test) {
        test1.fill_input(test);
    }

    public void click_button() {
        test1.ckick_button();
    }

    public void should_see_definition1111(String s) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test1.getText());
        assertThat(test1.getText(), containsString(s));
    }

    public void fill_pass(String sfgsf) {
        test1.fill_passs(sfgsf);
    }
}