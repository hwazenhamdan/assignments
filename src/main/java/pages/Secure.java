package pages;
import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Secure extends Pages{
    private final By successmasg = By.xpath("//h1[text()=' Your Account Has Been Created!']");

    public Secure(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    @Step ("Then I will be Registered successfully")
    public String readSuccessMessage(){
        return bot.getText(successmasg);
    }
}