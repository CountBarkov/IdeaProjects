package SeleniumJUnit4;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class JUnit4reg {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.23traders.com/en/");
        selenium.start();
    }

    @Test
    public void JUnit4reg() throws Exception {
        selenium.open("https://www.23traders.com/en/");
        selenium.click("class=sign-up-now");
        selenium.waitForPageToLoad("30000");
        //selenium.open("https://www.23traders.com/en/registration/");
        selenium.type("id=first-name", "Test");
        selenium.type("id=last-name", "Test");
        String s1 = "testregprodfull";
        String s2 = "@mail.org";
        long timestamp = System.currentTimeMillis() / 1000;
        String s = s1 + timestamp + s2;
        selenium.type("id=email", s);
        selenium.type("id=password", "qwerty");
        selenium.type("id=phone", "123123456");
        selenium.select("id=currency", "label=USD");
        selenium.click("css=section > #wp-submit");
        selenium.click("id=agree");
        selenium.click("css=section > #wp-submit");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (selenium.isVisible("css=span.message > section.dnd_section_dd.thank-you-page > div.dnd_section_content > div.dnd_container > div.dnd_column_dd_span12. > section.thank-you-block > footer > div.hide-for-not-supported.button-block > span.start-trading-link.button-big")) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        selenium.click("css=span.message > section.dnd_section_dd.thank-you-page > div.dnd_section_content > div.dnd_container > div.dnd_column_dd_span12. > section.thank-you-block > footer > div.hide-for-not-supported.button-block > span.start-trading-link.button-big");
        selenium.waitForPageToLoad("30000");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (selenium.isVisible("id=spotPackageContainer_myAccount")) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        selenium.click("link=Sign Out");
        selenium.waitForPageToLoad("30000");
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
