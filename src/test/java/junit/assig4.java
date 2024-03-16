package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class assig4 extends Tester {
    /*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use engine.ActionsBot to type "ClarusWay" in the search box and perform the search
*/
@Test
    public void amazonTest() throws InterruptedException, AWTException {
    bot.navigate("http://amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

  //Scroll to the bottom of the page using a robot
     Robot robot=new Robot();
     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

  //Click on the "Back to top" web element.
    bot.click(By.id("navBackToTop"));

  //Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor.
    bot.click(By.xpath("//a[@id='nav-logo-sprites']"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

   // Use engine.ActionsBot to type "ClarusWay" in the search box and perform the search.
    Actions actions= new Actions(driver);
    By searchBar=By.id("twotabsearchtextbox");
    actions.moveToElement(driver.findElement(searchBar)).click().sendKeys("ClarusWay").perform();
}

}
