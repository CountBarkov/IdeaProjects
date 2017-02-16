package SeleniumJUnit4;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnit4Login {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.23traders.com/en/");
        selenium.start();
    }

    @Test
    public void JUnit4Login() throws Exception {
        selenium.open("https://www.23traders.com/en/login/");
        selenium.type("id=user_login", "pavel@23traders.com");
        selenium.type("id=user_pass", "qwertysun");
        selenium.click("id=wp-submit");
        //selenium.waitForPageToLoad("30000");
        Thread.sleep(20000);

        selenium.click("link=Sign Out");
        //selenium.click("class=so-logout");
        selenium.waitForPageToLoad("30000");

    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
