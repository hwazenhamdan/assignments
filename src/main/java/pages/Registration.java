package pages;
import engine.ActionsBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration extends Pages{
    private final String url = PropertiesReader.props.getProperty("baseUrl") ;
    private final By firstnameInput = By.id("input-firstname");
    private final By lastnameInput = By.id("input-lastname");
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By passwordconfirmInput = By.id("input-confirm");

    private final By agreeCheckbox = By.name("agree");
    private final By submitButton = By.cssSelector("input[type='submit']");



    public Registration(WebDriver driver, ActionsBot bot) {super(driver, bot);}
    @Step("Given I am on the Registration page")
    public Registration goTo(){
        bot.navigate(url);
        return this;
    }

    @Step ("When I successfully perform the Registration action")
    public Secure successfulLogin(String fname, String lname, String email, String telphone, String password, String confirmpass){
        register(fname, lname, email, telphone, password, confirmpass );
        return new Secure(driver,bot);
    }

    private void register(String fname, String lname, String email, String telphone, String password, String confirmpass){
        bot.type(firstnameInput, fname);
        bot.type(lastnameInput, lname);
        bot.type(emailInput, email);
        bot.type(telephoneInput, telphone);
        bot.type(passwordInput, password);
        bot.type(passwordconfirmInput, confirmpass);
        bot.click(agreeCheckbox);
        bot.click(submitButton);
    }

}
