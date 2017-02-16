package test.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://stage-registration.23traders.com/reports/deposit_group_behavior/")
public class LoginStageReports extends PageObject {

    @FindBy (id = "name")
    private WebElementFacade emailhField;

    @FindBy (id = "UserPassword")
    private WebElementFacade passField;

    @FindBy (id = "submit")
    private  WebElementFacade button;

    @FindBy (name = "Period")
    private WebElementFacade log;


    public void fill_input(String test) {
        emailhField.type(test);
    }

    public String  getText() {

        String text = log.getText();
        return  text;
    }

    public List<String> getDefinitions1() {
        WebElementFacade definitionList = find(By.name("Period"));
        List<WebElement> results = definitionList.findElements(By.tagName("a"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };

    }

    public void fill_password(String s1) {
        passField.type(s1);
    }

    public void ckick_button() {
        button.click();
    }
}
