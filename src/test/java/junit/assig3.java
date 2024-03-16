package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class assig3 extends Tester{
    //( This task should be managed with keyboard actions )
    // go to https://www.google.com/
    // search for "Scroll Methods" by using an engine.ActionsBot object
    @Test
    public void searchScrolling(){
        // search for "Scroll Methods" by using an engine.ActionsBot object
        bot.navigate("https://www.google.com/");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("textarea"))).click().sendKeys("SCROLL METHODS").perform();
    }
}
