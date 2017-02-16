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

/**
 * Created by Pavel on 03.04.16.
 */@DefaultUrl("https://www.23traders.com/en/")
public class login23tr extends PageObject {

    @FindBy (id = "user_login")
    private WebElementFacade emailhField;

    @FindBy (id = "user_pass")
    private WebElementFacade passField;

    @FindBy (id = "wp-submit")
    private  WebElementFacade button;

    @FindBy (xpath = "/html/body/header/div[2]/section/div/div[2]/div[1]/span/span")
    private WebElementFacade log;


    public void fill_input(String test) {
        emailhField.type(test);
    }

    public String  getText() {

        String text = log.getText();
        return  text;
    }

    public List<String> getDefinitionsTest() {
        WebElementFacade definitionList = find(By.tagName("h3"));
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

    public void fill_passs(String sfgsf) {
        passField.type(sfgsf);
    }

    public void ckick_button() {
        button.click();
    }
}
